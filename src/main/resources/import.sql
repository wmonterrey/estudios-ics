INSERT INTO `roles` (`ROL`) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_sistema` (`NOMBRE_USUARIO`, `CUENTA_SINEXPIRAR`, `CUENTA_SINBLOQUEAR`, `DESCRIPCION`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `CREDENCIAL_SINEXPIRAR`, `CORREO_ELECTRONICO`, `HABILITADO`, `FECHA_ULTACC`, `FECHA_ULTMODCRED`, `FECHA_ULTMOD`, `USUARIO_ULTMOD`, `CONTRASENA`) VALUES ('admin', '', '', 'Administrador', '2014-09-20 08:31:00', 'admin', '', 'admincndr@minsa.gob.ni', '', '2014-11-16 10:05:40', NULL, '2014-11-13 17:58:06', 'admin', '6c36dc262b0e44be5811c2296669fc65643aec9dcaa4a76501e0a9508b633fd01ee59a207f8c6d68');
INSERT INTO `usuarios_roles` (`ROL`, `NOMBRE_USUARIO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `ESTADO`) VALUES ('ROLE_ADMIN', 'admin', '0', '2016-06-07 10:47:12', 'admin', '1');

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
INSERT INTO `mensajes` (`messageKey`, `es`, `catPasive`, `isCat`, `orden`) VALUES ( 'logout', 'Salir','0','0',0);


/*Catalogos*/
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SINO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo Si No CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SINO_SI', 'S', 'CHF_CAT_SINO', NULL, '0', 1, '0', 'Si');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SINO_NO', 'N', 'CHF_CAT_SINO', NULL, '0', 2, '0', 'No');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SEXO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo Sexo CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SEXO_M', 'M', 'CHF_CAT_SEXO', NULL, '0', 1, '0', 'Masculino');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SEXO_F', 'F', 'CHF_CAT_SEXO', NULL, '0', 2, '0', 'Femenino');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NP', NULL, NULL, NULL, '1', 0, '0', 'Catalogo no participa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NP_01', '1', 'CHF_CAT_NP', NULL, '0', 1, '0', 'No desea participar en el estudio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NP_02', '2', 'CHF_CAT_NP', NULL, '0', 1, '0', 'Cambiara de Domicilio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NP_03', '3', 'CHF_CAT_NP', NULL, '0', 1, '0', 'No se ubica el domicilio');            
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NP_04', '4', 'CHF_CAT_NP', NULL, '0', 1, '0', 'Tiene seguro médico');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DF', NULL, NULL, NULL, '1', 0, '0', 'Catalogo ubicacion dentro o fuera de casa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DF_01', '1', 'CHF_CAT_DF', NULL, '0', 1, '0', 'Fuera');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DF_02', '2', 'CHF_CAT_DF', NULL, '0', 2, '0', 'Dentro');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DF_03', '3', 'CHF_CAT_DF', NULL, '0', 3, '0', 'Dentro y Fuera');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_COMPARTIDO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo llave agua compartida CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_COMPARTIDO_C', '1', 'CHF_CAT_COMPARTIDO', NULL, '0', 1, '0', 'Compartido');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_COMPARTIDO_N', '2', 'CHF_CAT_COMPARTIDO', NULL, '0', 2, '0', 'No compartido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipo material de paredes casa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_01', '1', 'CHF_CAT_MAT_PARED', NULL, '0', 1, '0', 'Madera');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_02', '2', 'CHF_CAT_MAT_PARED', NULL, '0', 2, '0', 'Concreto');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_03', '3', 'CHF_CAT_MAT_PARED', NULL, '0', 3, '0', 'Plástico');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_04', '4', 'CHF_CAT_MAT_PARED', NULL, '0', 4, '0', 'Cartón');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_05', '5', 'CHF_CAT_MAT_PARED', NULL, '0', 5, '0', 'Adobe');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_06', '6', 'CHF_CAT_MAT_PARED', NULL, '0', 6, '0', 'Zinc');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PARED_998', '998', 'CHF_CAT_MAT_PARED', NULL, '0', 7, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PISO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipo material de piso casa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PISO_01', '1', 'CHF_CAT_MAT_PISO', NULL, '0', 1, '0', 'Concreto');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PISO_02', '2', 'CHF_CAT_MAT_PISO', NULL, '0', 2, '0', 'Ladrillos');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PISO_03', '3', 'CHF_CAT_MAT_PISO', NULL, '0', 3, '0', 'Piso de tierra');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PISO_04', '4', 'CHF_CAT_MAT_PISO', NULL, '0', 4, '0', 'Cerámica');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_PISO_998', '998', 'CHF_CAT_MAT_PISO', NULL, '0', 5, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_TECHO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipo material de techo casa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_TECHO_01', '1', 'CHF_CAT_MAT_TECHO', NULL, '0', 1, '0', 'Zinc');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_TECHO_02', '2', 'CHF_CAT_MAT_TECHO', NULL, '0', 2, '0', 'Plástico');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_TECHO_03', '3', 'CHF_CAT_MAT_TECHO', NULL, '0', 3, '0', 'Tejas');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_TECHO_04', '998', 'CHF_CAT_MAT_TECHO', NULL, '0', 4, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FUN_ABANICO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tiempo de funcionamiento aire acondicionado CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FUN_ABANICO_D', '1', 'CHF_CAT_FUN_ABANICO', NULL, '0', 1, '0', 'Día');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FUN_ABANICO_N', '2', 'CHF_CAT_FUN_ABANICO', NULL, '0', 2, '0', 'Noche');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo frecuencia de uso cocina de lenia CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_D', '1', 'CHF_CAT_FREC_COCINA', NULL, '0', 1, '0', 'Diario');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_S', '2', 'CHF_CAT_FREC_COCINA', NULL, '0', 2, '0', 'Semanal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_Q', '3', 'CHF_CAT_FREC_COCINA', NULL, '0', 3, '0', 'Quincenal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_M', '4', 'CHF_CAT_FREC_COCINA', NULL, '0', 4, '0', 'Mensual');
