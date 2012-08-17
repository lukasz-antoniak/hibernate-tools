package org.hibernate.tool.ant.envers;

import java.lang.reflect.Method;

import org.apache.tools.ant.BuildException;

import org.hibernate.cfg.Configuration;
import org.hibernate.internal.util.ReflectHelper;

/**
 * @author Lukasz Antoniak (lukasz dot antoniak at gmail dot com)
 */
public abstract class EnversIntegrationUtils {
	/**
	 * Configure audit entity mappings.
	 * @param configuration Configuration with already build entity mappings.
	 * @param caller Caller class.
	 */
	public static void configureAuditMappings(Configuration configuration, Class caller) {
		try {
			final Class clazz = ReflectHelper.classForName( "org.hibernate.envers.configuration.AuditConfiguration", caller );
			final Method method = clazz.getMethod( "getFor", new Class[] { Configuration.class } );
			method.invoke( null, configuration );
		}
		catch ( ClassNotFoundException e ) {
			throw new BuildException(
					"Failed to locate org.hibernate.envers.configuration.AuditConfiguration class. " +
							"Please make sure that Hibernate Envers JAR exists in the classpath.",
					e
			);
		}
		catch ( NoSuchMethodException e ) {
			throw new BuildException(
					"Failed to locate org.hibernate.envers.configuration.AuditConfiguration#getFor(Configuration) method. " +
							"Please make sure that appropriate Hibernate Envers version is being used.",
					e
			);
		}
		catch ( Exception e ) {
			throw new BuildException( "Problems in configuring audit mappings.", e );
		}
	}
}
