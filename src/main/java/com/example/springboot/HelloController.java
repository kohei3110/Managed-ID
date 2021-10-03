package com.example.springboot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;
import com.azure.security.keyvault.secrets.models.SecretProperties;

@RestController
public class HelloController {

    static String VAULT_URL = "https://keyvault01-koheisaito.vault.azure.net/";

	@GetMapping("/")
	public String index() {

        /**
         * Authenticate with a managed identity.
         */
        ManagedIdentityCredential managedIdentityCredential = new ManagedIdentityCredentialBuilder()
            .build();

        /**
         * Azure SDK client builders accept the credential as a parameter.
         */
        SecretClient secretClient = new SecretClientBuilder()
            .vaultUrl(VAULT_URL)
            .credential(managedIdentityCredential)
            .buildClient();

        String secretVersion = "xxxxxx";

        for (SecretProperties secret : secretClient.listPropertiesOfSecretVersions("Password")) {
            secretVersion = secret.getVersion();
        }

		return secretVersion;
	}

}
