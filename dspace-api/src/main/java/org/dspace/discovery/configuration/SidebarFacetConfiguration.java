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

/**
 * @author Kevin Van de Velde (kevin at atmire dot com)
 */
public class SidebarFacetConfiguration {

    //Let the configuration manager retrieve this !
    private static final int DEFAULT_FACET_LIMIT = 10;
    private final String indexFieldName;
    private final List<String> metadataFields;
    private int facetLimit = -1;
    private DiscoveryConfigurationParameters.SORT sortOrder = DiscoveryConfigurationParameters.SORT.COUNT;
    private String type = DiscoveryConfigurationParameters.TYPE_TEXT;

    /**
     * Initialize a new configuration with required fields
     * @param indexFieldName name of facet in index
     * @param metadataFields DSpace metadata fields to add to the indexed facet
     */
    @Autowired
    public SidebarFacetConfiguration(String indexFieldName, List<String> metadataFields) {
        this.indexFieldName = indexFieldName;
        this.metadataFields = metadataFields;
    }

    public String getIndexFieldName() {
        return indexFieldName;
    }

    public List<String> getMetadataFields() {
        return metadataFields;
    }

    public int getFacetLimit() {
        if (facetLimit == -1) {
            return DEFAULT_FACET_LIMIT;
        } else {
            return facetLimit;
        }
    }

    public void setFacetLimit(int facetLimit) {
        this.facetLimit = facetLimit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        if (type.equalsIgnoreCase(DiscoveryConfigurationParameters.TYPE_TEXT)) {
            this.type = DiscoveryConfigurationParameters.TYPE_TEXT;
        } else if (type.equalsIgnoreCase(DiscoveryConfigurationParameters.TYPE_DATE)) {
            this.type = DiscoveryConfigurationParameters.TYPE_DATE;
        } else {
            this.type = type;
        }
    }

    public DiscoveryConfigurationParameters.SORT getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(DiscoveryConfigurationParameters.SORT sortOrder) {
        this.sortOrder = sortOrder;
    }
}
