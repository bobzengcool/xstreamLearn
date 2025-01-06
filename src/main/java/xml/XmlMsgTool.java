package xml;

import java.util.Objects;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.thoughtworks.xstream.XStream;

public class XmlMsgTool {
    /**
     * 将任意Java类的对象转换为XML报文的静态方法
     *
     * @param obj               要转换为XML报文的Java对象
     * @param additionalClasses 可选的其他相关类的Class数组，用于处理复杂场景下涉及的其他类信息（可按需传入）
     * @param <T>               泛型参数，表示传入对象的类型
     * @return XML报文形式的字符串，如果转换出现问题可能返回空字符串（可根据实际需求优化异常处理逻辑）
     */
    public static <T> String objectToXml(T obj, Class<?>[] additionalClasses) {
        try {
            // Validate the object
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<T>> violations = validator.validate(obj);
            System.out.println("objectToXml 转换报文前," + violations.size());

            if (!violations.isEmpty()) {
                StringBuilder validationErrors = new StringBuilder("Validation failed:");
                for (ConstraintViolation<T> violation : violations) {
                    validationErrors.append(" ").append(violation.getRootBean()).append(violation.getPropertyPath())
                            .append(violation.getMessage());

                }
                throw new IllegalArgumentException(validationErrors.toString());
            }

            XStream xstream = new XStream();
            xstream.autodetectAnnotations(true);
            xstream.aliasSystemAttribute(null, "class");
            if (obj != null) {
                Class<?> clazz = obj.getClass();
                xstream.processAnnotations(clazz);
            }
            if (additionalClasses != null && additionalClasses.length > 0) {
                xstream.allowTypes(additionalClasses);
            }

            return xstream.toXML(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 将XML报文转换为指定类型的对象的静态方法
     *
     * @param xml               表示XML报文内容的字符串
     * @param type              要转换成为的目标对象类型对应的Class对象，通过此参数指定返回对象的类型
     * @param additionalClasses 可选的其他相关类的Class数组，用于处理复杂场景下涉及的其他类信息（可按需传入）
     * @param <T>               泛型参数，表示要转换的目标对象类型
     * @return 转换后的目标类型对象，如果转换出现问题可能返回null（可根据实际需求优化异常处理逻辑）
     */
    public static <T> T xmlToObject(String xml, Class<T> type, Class<?>[] additionalClasses) {
        Objects.requireNonNull(xml, "XML content must not be null");
        Objects.requireNonNull(type, "Target type must not be null");

        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        xstream.processAnnotations(type);

        if (additionalClasses != null && additionalClasses.length > 0) {
            xstream.allowTypes(additionalClasses);
        }

        try {
            return type.cast(xstream.fromXML(xml));
        } catch (Exception e) {
            // LOGGER.log(Level.SEVERE, "Error converting XML to object", e);
            return null;
        }
    }
}
