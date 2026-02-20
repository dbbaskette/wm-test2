## Reasoning Approach

- Think through this problem step by step before implementing
- Consider edge cases and potential issues
- Evaluate multiple approaches before choosing one

# Directive: DIR-005

## Objective

Create the React frontend components.

## Additional Context

Create the following React components: App.js (main entry point), ToDoList.js (displays a list of to-do items), ToDoItem.js (displays a single to-do item and allows marking as complete or deleting), and ToDoForm.js (allows adding a new to-do item). Use the Fetch API or Axios to make requests to the Spring Boot REST API. Handle errors gracefully. Update the UI automatically when to-do items are added, updated, or deleted. Display the due date in a user-friendly format. Display the priority as High, Medium, or Low. Display the category as a string.

## Project Context

- **Language:** unknown
- **Framework:** unknown
- **Summary:** unknown project with 823 files

### File Structure

```
.java-buildpack
.java-buildpack/java_main
.java-buildpack/java_main/spring-generations.json
.java-buildpack/open_jdk_jre
.java-buildpack/open_jdk_jre/lib
.java-buildpack/open_jdk_jre/lib/libfontmanager.so
.java-buildpack/open_jdk_jre/lib/libprefs.so
.java-buildpack/open_jdk_jre/lib/libjavajpeg.so
.java-buildpack/open_jdk_jre/lib/classlist
.java-buildpack/open_jdk_jre/lib/librmi.so
.java-buildpack/open_jdk_jre/lib/libjli.so
.java-buildpack/open_jdk_jre/lib/libfreetype.so
.java-buildpack/open_jdk_jre/lib/psfontj2d.properties
.java-buildpack/open_jdk_jre/lib/libjava.so
.java-buildpack/open_jdk_jre/lib/psfont.properties.ja
.java-buildpack/open_jdk_jre/lib/libj2gss.so
.java-buildpack/open_jdk_jre/lib/libsctp.so
.java-buildpack/open_jdk_jre/lib/libawt_xawt.so
.java-buildpack/open_jdk_jre/lib/libsplashscreen.so
.java-buildpack/open_jdk_jre/lib/jrt-fs.jar
.java-buildpack/open_jdk_jre/lib/libmanagement_agent.so
.java-buildpack/open_jdk_jre/lib/libmanagement.so
.java-buildpack/open_jdk_jre/lib/libjaas.so
.java-buildpack/open_jdk_jre/lib/libdt_socket.so
.java-buildpack/open_jdk_jre/lib/libjawt.so
.java-buildpack/open_jdk_jre/lib/libjsvml.so
.java-buildpack/open_jdk_jre/lib/libsyslookup.so
.java-buildpack/open_jdk_jre/lib/libverify.so
.java-buildpack/open_jdk_jre/lib/jspawnhelper
.java-buildpack/open_jdk_jre/lib/libawt_headless.so
.java-buildpack/open_jdk_jre/lib/libjsound.so
.java-buildpack/open_jdk_jre/lib/modules
.java-buildpack/open_jdk_jre/lib/libextnet.so
.java-buildpack/open_jdk_jre/lib/libjsig.so
.java-buildpack/open_jdk_jre/lib/libjimage.so
.java-buildpack/open_jdk_jre/lib/libinstrument.so
.java-buildpack/open_jdk_jre/lib/liblcms.so
.java-buildpack/open_jdk_jre/lib/libjdwp.so
.java-buildpack/open_jdk_jre/lib/tzdb.dat
.java-buildpack/open_jdk_jre/lib/libmanagement_ext.so
.java-buildpack/open_jdk_jre/lib/libnet.so
.java-buildpack/open_jdk_jre/lib/libmlib_image.so
.java-buildpack/open_jdk_jre/lib/jexec
.java-buildpack/open_jdk_jre/lib/libj2pcsc.so
.java-buildpack/open_jdk_jre/lib/libj2pkcs11.so
.java-buildpack/open_jdk_jre/lib/libzip.so
.java-buildpack/open_jdk_jre/lib/libawt.so
.java-buildpack/open_jdk_jre/lib/jvm.cfg
.java-buildpack/open_jdk_jre/lib/jfr
.java-buildpack/open_jdk_jre/lib/jfr/default.jfc
.java-buildpack/open_jdk_jre/lib/jfr/profile.jfc
.java-buildpack/open_jdk_jre/lib/libnio.so
.java-buildpack/open_jdk_jre/lib/client
.java-buildpack/open_jdk_jre/lib/client/classes_nocoops.jsa
.java-buildpack/open_jdk_jre/lib/client/libjsig.so
.java-buildpack/open_jdk_jre/lib/client/libjvm.so
.java-buildpack/open_jdk_jre/lib/client/classes.jsa
.java-buildpack/open_jdk_jre/lib/security
.java-buildpack/open_jdk_jre/lib/security/public_suffix_list.dat
.java-buildpack/open_jdk_jre/lib/security/blocked.certs
.java-buildpack/open_jdk_jre/lib/security/cacerts
.java-buildpack/open_jdk_jre/lib/security/default.policy
.java-buildpack/open_jdk_jre/lib/server
.java-buildpack/open_jdk_jre/lib/server/classes_nocoops.jsa
.java-buildpack/open_jdk_jre/lib/server/libjsig.so
.java-buildpack/open_jdk_jre/lib/server/libjvm.so
.java-buildpack/open_jdk_jre/lib/server/classes.jsa
.java-buildpack/open_jdk_jre/release
.java-buildpack/open_jdk_jre/readme.txt
.java-buildpack/open_jdk_jre/LICENSE
.java-buildpack/open_jdk_jre/conf
.java-buildpack/open_jdk_jre/conf/logging.properties
.java-buildpack/open_jdk_jre/conf/net.properties
.java-buildpack/open_jdk_jre/conf/jaxp.properties
.java-buildpack/open_jdk_jre/conf/sound.properties
.java-buildpack/open_jdk_jre/conf/sdp
.java-buildpack/open_jdk_jre/conf/sdp/sdp.conf.template
.java-buildpack/open_jdk_jre/conf/security
.java-buildpack/open_jdk_jre/conf/security/policy
.java-buildpack/open_jdk_jre/conf/security/policy/README.txt
.java-buildpack/open_jdk_jre/conf/security/policy/limited
.java-buildpack/open_jdk_jre/conf/security/policy/limited/exempt_local.policy
.java-buildpack/open_jdk_jre/conf/security/policy/limited/default_US_export.policy
.java-buildpack/open_jdk_jre/conf/security/policy/limited/default_local.policy
.java-buildpack/open_jdk_jre/conf/security/policy/unlimited
.java-buildpack/open_jdk_jre/conf/security/policy/unlimited/default_US_export.policy
.java-buildpack/open_jdk_jre/conf/security/policy/unlimited/default_local.policy
.java-buildpack/open_jdk_jre/conf/security/java.policy
.java-buildpack/open_jdk_jre/conf/security/java.security
.java-buildpack/open_jdk_jre/conf/management
.java-buildpack/open_jdk_jre/conf/management/management.properties
.java-buildpack/open_jdk_jre/conf/management/jmxremote.access
.java-buildpack/open_jdk_jre/conf/management/jmxremote.password.template
.java-buildpack/open_jdk_jre/bin
.java-buildpack/open_jdk_jre/bin/jvmkill-1.17.0_RELEASE
.java-buildpack/open_jdk_jre/bin/java-buildpack-memory-calculator-3.13.0_RELEASE
.java-buildpack/open_jdk_jre/bin/java
.java-buildpack/open_jdk_jre/bin/keytool
.java-buildpack/open_jdk_jre/bin/jrunscript
.java-buildpack/open_jdk_jre/bin/rmiregistry
.java-buildpack/open_jdk_jre/bin/jwebserver
.java-buildpack/open_jdk_jre/bin/jfr
.java-buildpack/open_jdk_jre/legal
.java-buildpack/open_jdk_jre/legal/java.prefs
.java-buildpack/open_jdk_jre/legal/java.prefs/LICENSE
.java-buildpack/open_jdk_jre/legal/java.prefs/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.prefs/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.naming
.java-buildpack/open_jdk_jre/legal/java.naming/LICENSE
.java-buildpack/open_jdk_jre/legal/java.naming/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.naming/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.localedata
.java-buildpack/open_jdk_jre/legal/jdk.localedata/thaidict.md
.java-buildpack/open_jdk_jre/legal/jdk.localedata/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.localedata/cldr.md
.java-buildpack/open_jdk_jre/legal/jdk.localedata/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.localedata/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.internal.vm.ci
.java-buildpack/open_jdk_jre/legal/jdk.internal.vm.ci/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.internal.vm.ci/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.internal.vm.ci/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.security.jgss
.java-buildpack/open_jdk_jre/legal/java.security.jgss/LICENSE
.java-buildpack/open_jdk_jre/legal/java.security.jgss/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.security.jgss/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.charsets
.java-buildpack/open_jdk_jre/legal/jdk.charsets/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.charsets/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.charsets/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.jfr
.java-buildpack/open_jdk_jre/legal/jdk.jfr/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.jfr/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.jfr/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.transaction.xa
.java-buildpack/open_jdk_jre/legal/java.transaction.xa/LICENSE
.java-buildpack/open_jdk_jre/legal/java.transaction.xa/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.transaction.xa/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.security.sasl
.java-buildpack/open_jdk_jre/legal/java.security.sasl/LICENSE
.java-buildpack/open_jdk_jre/legal/java.security.sasl/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.security.sasl/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.xml.crypto
.java-buildpack/open_jdk_jre/legal/java.xml.crypto/santuario.md
.java-buildpack/open_jdk_jre/legal/java.xml.crypto/LICENSE
.java-buildpack/open_jdk_jre/legal/java.xml.crypto/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.xml.crypto/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.security.jgss
.java-buildpack/open_jdk_jre/legal/jdk.security.jgss/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.security.jgss/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.security.jgss/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.xml
.java-buildpack/open_jdk_jre/legal/java.xml/dom.md
.java-buildpack/open_jdk_jre/legal/java.xml/jcup.md
.java-buildpack/open_jdk_jre/legal/java.xml/bcel.md
.java-buildpack/open_jdk_jre/legal/java.xml/xerces.md
.java-buildpack/open_jdk_jre/legal/java.xml/xalan.md
.java-buildpack/open_jdk_jre/legal/java.xml/LICENSE
.java-buildpack/open_jdk_jre/legal/java.xml/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.xml/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.jsobject
.java-buildpack/open_jdk_jre/legal/jdk.jsobject/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.jsobject/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.jsobject/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.xml.dom
.java-buildpack/open_jdk_jre/legal/jdk.xml.dom/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.xml.dom/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.xml.dom/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.naming.dns
.java-buildpack/open_jdk_jre/legal/jdk.naming.dns/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.naming.dns/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.naming.dns/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.crypto.ec
.java-buildpack/open_jdk_jre/legal/jdk.crypto.ec/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.crypto.ec/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.crypto.ec/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.logging
.java-buildpack/open_jdk_jre/legal/java.logging/LICENSE
.java-buildpack/open_jdk_jre/legal/java.logging/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/java.logging/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.management
.java-buildpack/open_jdk_jre/legal/jdk.management/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.management/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.management/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.jdwp.agent
.java-buildpack/open_jdk_jre/legal/jdk.jdwp.agent/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.jdwp.agent/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.jdwp.agent/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.crypto.cryptoki
.java-buildpack/open_jdk_jre/legal/jdk.crypto.cryptoki/pkcs11cryptotoken.md
.java-buildpack/open_jdk_jre/legal/jdk.crypto.cryptoki/pkcs11wrapper.md
.java-buildpack/open_jdk_jre/legal/jdk.crypto.cryptoki/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.crypto.cryptoki/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.crypto.cryptoki/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/jdk.httpserver
.java-buildpack/open_jdk_jre/legal/jdk.httpserver/LICENSE
.java-buildpack/open_jdk_jre/legal/jdk.httpserver/ASSEMBLY_EXCEPTION
.java-buildpack/open_jdk_jre/legal/jdk.httpserver/ADDITIONAL_LICENSE_INFO
.java-buildpack/open_jdk_jre/legal/java.sql.rowset
.java-buildpack/open_jdk_jre/legal/java.sql.rowset/LICENSE
.java-buildpack/open_jdk_jre/legal/java.sql.rowset/ASSEMBLY_EXCEPTION
... and 623 more files

```

## Success Criteria

React frontend components are created and function as described in the PRD. The UI is updated automatically when to-do items are added, updated, or deleted. Error handling is implemented.

## Constraints

- **NAMING**: Name things according to their function. App names, project names, and config files should describe what the application does (e.g., `snake-game`, `todo-api`), not generic names like `my-app` or `worldmind-app`.
- **CRITICAL**: You MUST create/modify the files described in the objective. Do NOT exit until you have actually written the code. If you only explore the codebase without creating files, this directive will FAIL.
- **FUNCTIONAL COMPLETENESS**: Deliver working, functional code — not scaffolding or placeholders. Before committing, verify it actually works: run it, test it, confirm the core functionality operates as expected. If something doesn't work, fix it before finishing.
- Only modify files related to this directive
- Do not modify test files (Gauntlet handles tests)
- When finished, stage and commit all changes: `git add -A && git commit -m 'done'`
- If you encounter an error, attempt to fix it before reporting failure

## Available Tools

- **Web Search**: You have web search available. Use it to look up documentation, APIs, best practices, or examples when implementing unfamiliar technologies.
- **File Operations**: Read, write, and modify files in the workspace.

## Cloud Foundry Deployment

If you create a `manifest.yml`:
- Use `default-route: true` — NEVER hardcode routes like `route: app.apps.example.com`
- **Staticfile apps**: Create a `Staticfile` config with `root: public` and place HTML/CSS/JS in `public/`
- **Java apps**: Ensure path matches where the JAR is built (usually `target/`)
- **Node apps**: Ensure `package.json` exists with a valid `start` script
- Verify the deployment config matches the actual file structure before committing
