/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.discovery.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * Class that contains all the configuration concerning the hit highlighting in search results
 * This class can be configured in the [dspace.dir]/config/spring/api/discovery.xml
 *
 * @author Kevin Van de Velde (kevin at atmire dot com)
 * @author Ben Bosman (ben at atmire dot com)
 * @author Mark Diggory (markd at atmire dot com)
 */
public class DiscoveryHitHighlightingConfiguration {

    /* A list of metadata fields for which the hit highlighting is possible */
    private final List<DiscoveryHitHighlightFieldConfiguration> metadataFields;

    /**
     * Initialize a new configuration for a specific set of metadata fields
     * @param metadataFields fields for which hit highlighting is possible
     */
    @Autowired
    public DiscoveryHitHighlightingConfiguration(List<DiscoveryHitHighlightFieldConfiguration> metadataFields) {
        this.metadataFields = metadataFields;
    }

    public List<DiscoveryHitHighlightFieldConfiguration> getMetadataFields() {
        return metadataFields;
    }
}
