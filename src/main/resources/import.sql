INSERT INTO `roles` (`ROL`) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_sistema` (`NOMBRE_USUARIO`, `CUENTA_SINEXPIRAR`, `CUENTA_SINBLOQUEAR`, `DESCRIPCION`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `CREDENCIAL_SINEXPIRAR`, `CORREO_ELECTRONICO`, `HABILITADO`, `FECHA_ULTACC`, `FECHA_ULTMODCRED`, `FECHA_ULTMOD`, `USUARIO_ULTMOD`, `CONTRASENA`) VALUES ('admin', '', '', 'Administrador', '2014-09-20 08:31:00', 'admin', '', 'admincndr@minsa.gob.ni', '', '2014-11-16 10:05:40', NULL, '2014-11-13 17:58:06', 'admin', '6c36dc262b0e44be5811c2296669fc65643aec9dcaa4a76501e0a9508b633fd01ee59a207f8c6d68');
INSERT INTO `usuarios_roles` (`ROL`, `NOMBRE_USUARIO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`) VALUES ('ROLE_ADMIN', 'admin', '0', '2016-06-07 10:47:12', 'admin');

/*Plantilla*/
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'heading', 'Cohorte Influenza, Dengue','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'title', 'Estudios de Investigación','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'footer', 'Instituto de Ciencias Sostenibles','0','0',0);

/*login page*/
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login', 'Ingresar','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.accountExpired', 'Cuenta de usuario ha expirado!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.accountLocked', 'Cuenta de usuario está bloqueada!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.accountNotLocked', 'Cuenta de usuario está desbloqueada!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.badCredentials', 'Nombre de usuario o contraseña incorrectos!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.credentialsExpired', 'Credenciales de usuario han expirado!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.maxSessionsOut', 'Tiene una sesión activa! No puede crear otra!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.message', 'Por favor ingresar su nombre de usuario y contraseña','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.username', 'Nombre de usuario','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.password', 'Contraseña','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.forgot.password', 'Olvidó contraseña?','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.userEnabled', 'Usuario esta activo!','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'login.userDisabled', 'Usuario esta inactivo!','0','0',0);


/*Menu*/
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'home', 'Inicio','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'dashboard', 'Panel de control','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'admin', 'Administración','0','0',0);
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'users', 'Usuarios','0','0',0);


