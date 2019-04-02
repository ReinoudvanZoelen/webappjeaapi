./subsystem=security/security-domain=application-security/:add

./subsystem=security/security-domain=application-security/authentication=classic:add(login-modules=[{code=Database, flag=Required, module-options={dsJndiName="java:/JEAWebAppDB", principalsQuery="SELECT passwd FROM credential WHERE uname = ?", rolesQuery="SELECT urole, 'Roles' from credential WHERE uname = ?"}}]