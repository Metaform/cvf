package cvf.ids.system.api.connector;

import cvf.core.api.system.Inject;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * For field injection, used in conjunction with {@link Inject} to specify the injection of a provider connector. Note that {@link Inject} is not needed for parameter injection.
 */
@Inherited
@Retention(RUNTIME)
@Target({FIELD, PARAMETER})
public @interface Provider {
}
