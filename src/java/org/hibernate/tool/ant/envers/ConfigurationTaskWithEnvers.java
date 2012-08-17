package org.hibernate.tool.ant.envers;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.ant.ConfigurationTask;

/**
 * @author Adam Warski (adam at warski dot org)
 */
public class ConfigurationTaskWithEnvers extends ConfigurationTask {
	protected void doConfiguration(Configuration configuration) {
		super.doConfiguration( configuration );
		configuration.buildMappings(); // Make sure that user entities are already mapped.
		EnversIntegrationUtils.configureAuditMappings( configuration, ConfigurationTaskWithEnvers.class );
	}
}