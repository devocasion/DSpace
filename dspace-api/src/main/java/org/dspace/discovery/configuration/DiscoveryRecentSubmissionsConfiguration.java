/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.discovery.configuration;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Kevin Van de Velde (kevin at atmire dot com)
 */
public class DiscoveryRecentSubmissionsConfiguration {

    private final String metadataSortField;
    private String type;

    private final int max;
    private boolean useAsHomePage;

    /**
     * Initialize configuration with required fields
     * @param metadataSortField metadata field to sort on
     * @param max maximum number of results to display/return
     */
    @Autowired
    public DiscoveryRecentSubmissionsConfiguration(String metadataSortField, int max) {
        this.metadataSortField = metadataSortField;
        this.max = max;
    }

    public String getMetadataSortField() {
        return metadataSortField;
    }

    public int getMax() {
        return max;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUseAsHomePage(boolean useAsHomePage) {
        this.useAsHomePage = useAsHomePage;
    }

    public boolean getUseAsHomePage() {
        return useAsHomePage;
    }
}
