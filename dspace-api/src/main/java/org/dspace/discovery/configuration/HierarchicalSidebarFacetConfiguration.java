/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.discovery.configuration;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Special sidebar facet configuration used for hierarchical facets
 *
 * @author Kevin Van de Velde (kevin at atmire dot com)
 * @author Ben Bosman (ben at atmire dot com)
 * @author Mark Diggory (markd at atmire dot com)
 */
public class HierarchicalSidebarFacetConfiguration extends DiscoverySearchFilterFacet {

    private final String splitter;
    private boolean skipFirstNodeLevel = true;

    /**
     * Initialize new hierarchical sidebar facet configuration
     * @param indexFieldName name of the search filter in the Discovery index
     * @param metadataFields DSpace metadata fields to add to search filter
     * @param splitter String to use as the facet separator/splitter (for hierarchical facets)
     */
    @Autowired
    public HierarchicalSidebarFacetConfiguration(String indexFieldName, List<String> metadataFields, String splitter) {
        // call parent to initialize required facet fields
        super(indexFieldName, metadataFields);

        // Then initialize our required splitter
        if (StringUtils.isBlank(splitter)) {
            splitter = "::";
        }
        this.splitter = splitter;

        //Our default type is the hierarchical, can be overridden by the configuration
        this.type = DiscoveryConfigurationParameters.TYPE_HIERARCHICAL;
    }

    public String getSplitter() {
        return splitter;
    }

    public boolean isSkipFirstNodeLevel() {
        return skipFirstNodeLevel;
    }

    public void setSkipFirstNodeLevel(boolean skipFirstNodeLevel) {
        this.skipFirstNodeLevel = skipFirstNodeLevel;
    }

    @Override
    public void setType(String type) throws DiscoveryConfigurationException {
        if (type.equalsIgnoreCase(DiscoveryConfigurationParameters.TYPE_HIERARCHICAL)) {
            this.type = type;
        } else {
            throw new DiscoveryConfigurationException(
                "The " + type + " can't be used with a hierarchical facet side bar facet use the " +
                    "\"DiscoverySearchFilterFacet\" class instead.");
        }

    }
}
