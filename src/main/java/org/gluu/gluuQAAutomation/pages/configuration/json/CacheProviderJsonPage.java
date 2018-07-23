package org.gluu.gluuQAAutomation.pages.configuration.json;

import org.gluu.gluuQAAutomation.pages.AbstractPage;
import org.springframework.stereotype.Component;

@Component
public class CacheProviderJsonPage extends AbstractPage {

	public void checkProviderType(String type) {

	}

	public void verifyMemCache(String type, String servers, String maxOQL, String bufferSize, String expiration) {
		// TODO Auto-generated method stub

	}

	public void verifyRedisConfig(String type, String servers, String expiration) {
		// TODO Auto-generated method stub

	}

}
