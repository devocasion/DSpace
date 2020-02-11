/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */

package org.dspace.identifier.ezid;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Create configured EZID requests.
 *
 * <p>Common EZID constant properties are:</p>
 *
 * <dl>
 * <dt>EZID_SCHEME</dt>
 * <dd>URL scheme (e.g. "https")</dd>
 * <dt>EZID_HOST</dt>
 * <dd>Name of the EZID API host</dd>
 * <dt>EZID_PATH</dt>
 * <dd>Path to the API endpoints</dd>
 * </dl>
 *
 * @author mwood
 */
public class EZIDRequestFactory {
    private final String EZID_SCHEME;
    private final String EZID_HOST;
    private final String EZID_PATH;

    /**
     * Initialize a new EZID requestfactory with the given required settings
     * @param aEZID_SCHEME EZID URL scheme to set.
     * @param aEZID_HOST the EZID host to set.
     * @param aEZID_PATH the local path to the EZID API.
     */
    @Autowired
    public EZIDRequestFactory(String aEZID_SCHEME, String aEZID_HOST, String aEZID_PATH) {
        this.EZID_SCHEME = aEZID_SCHEME;
        this.EZID_HOST = aEZID_HOST;
        this.EZID_PATH = aEZID_PATH;
    }

    /**
     * Configure an EZID request.
     *
     * @param authority our DOI authority number.
     * @param username  EZID user name.
     * @param password  {@code username}'s password.
     * @return a new EZID request with the given parameters
     * @throws URISyntaxException if host or authority is bad.
     */
    public EZIDRequest getInstance(String authority, String username, String password)
        throws URISyntaxException {
        return new EZIDRequest(EZID_SCHEME, EZID_HOST, EZID_PATH,
                               authority, username, password);
    }

    public String getEzidScheme() {
        return EZID_SCHEME;
    }

    public String getEzidHost() {
        return EZID_HOST;
    }

    public String getEzidPath() {
        return EZID_PATH;
    }
}
