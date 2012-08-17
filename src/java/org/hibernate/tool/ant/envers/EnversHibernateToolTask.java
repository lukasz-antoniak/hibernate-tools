package org.hibernate.tool.ant.envers;

import org.hibernate.tool.ant.AnnotationConfigurationTask;
import org.hibernate.tool.ant.ConfigurationTask;
import org.hibernate.tool.ant.HibernateToolTask;
import org.hibernate.tool.ant.JPAConfigurationTask;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public class EnversHibernateToolTask extends HibernateToolTask {
	public JPAConfigurationTask createJpaConfiguration() {
		checkConfiguration();
		JPAConfigurationTask task = new JPAConfigurationTaskWithEnvers();
		configurationTask = task;
		return task;
	}

	public ConfigurationTask createConfiguration() {
		checkConfiguration();
		ConfigurationTaskWithEnvers task = new ConfigurationTaskWithEnvers();
		configurationTask = task;
		return task;
	}

	public AnnotationConfigurationTask createAnnotationConfiguration() {
		checkConfiguration();
		AnnotationConfigurationTaskWithEnvers task = new AnnotationConfigurationTaskWithEnvers();
		configurationTask = task;
		return task;
	}
}