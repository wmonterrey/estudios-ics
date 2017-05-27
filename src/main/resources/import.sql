INSERT INTO `roles` (`ROL`) VALUES ('ROLE_ADMIN');

INSERT INTO `usuarios_sistema` (`NOMBRE_USUARIO`, `CUENTA_SINEXPIRAR`, `CUENTA_SINBLOQUEAR`, `DESCRIPCION`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `CREDENCIAL_SINEXPIRAR`, `CORREO_ELECTRONICO`, `HABILITADO`, `FECHA_ULTACC`, `FECHA_ULTMODCRED`, `FECHA_ULTMOD`, `USUARIO_ULTMOD`, `CONTRASENA`) VALUES ('admin', '', '', 'Administrador', '2014-09-20 08:31:00', 'admin', '', 'admincndr@minsa.gob.ni', '', '2014-11-16 10:05:40', NULL, '2014-11-13 17:58:06', 'admin', '6c36dc262b0e44be5811c2296669fc65643aec9dcaa4a76501e0a9508b633fd01ee59a207f8c6d68');
INSERT INTO `usuarios_roles` (`ROL`, `NOMBRE_USUARIO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `ESTADO`) VALUES ('ROLE_ADMIN', 'admin', '0', '2016-06-07 10:47:12', 'admin', '1');

INSERT INTO `estudios` (`CODIGO`, `IDENTIFICADOR_EQUIPO`, `ESTADO`, `PASIVO`, `FECHA_REGISTRO`, `USUARIO_REGISTRO`, `NOMBRE`) VALUES ('1', 'server', '1', '0', '2017-05-23', 'admin', 'Estudio Cohorte Familia');
INSERT INTO `estudios_ics`.`estudios` (`CODIGO`, `ESTADO`, `PASIVO`, `NOMBRE`) VALUES (2, '0', '0', 'Seroprevalencia Arbovirus');

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
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MAT_TECHO_998', '998', 'CHF_CAT_MAT_TECHO', NULL, '0', 4, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FUN_ABANICO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tiempo de funcionamiento aire acondicionado CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FUN_ABANICO_D', '1', 'CHF_CAT_FUN_ABANICO', NULL, '0', 1, '0', 'Día');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FUN_ABANICO_N', '2', 'CHF_CAT_FUN_ABANICO', NULL, '0', 2, '0', 'Noche');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo frecuencia de uso cocina de lenia CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_D', '1', 'CHF_CAT_FREC_COCINA', NULL, '0', 1, '0', 'Diario');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_S', '2', 'CHF_CAT_FREC_COCINA', NULL, '0', 2, '0', 'Semanal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_Q', '3', 'CHF_CAT_FREC_COCINA', NULL, '0', 3, '0', 'Quincenal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_COCINA_M', '4', 'CHF_CAT_FREC_COCINA', NULL, '0', 4, '0', 'Mensual');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NV', NULL, NULL, NULL, '1', 0, '0', 'Catalogo visita no exitosa');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NV_01', '1', 'CHF_CAT_NV', NULL, '0', 1, '0', 'No se ubica el domicilio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NV_02', '2', 'CHF_CAT_NV', NULL, '0', 2, '0', 'Casa cerrada');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NV_03', '3', 'CHF_CAT_NV', NULL, '0', 3, '0', 'Cambio domicilio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NV_04', '4', 'CHF_CAT_NV', NULL, '0', 4, '0', 'No está jefe casa');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NV_998', '998', 'CHF_CAT_NV', NULL, '0', 5, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT', NULL, NULL, NULL, '1', 0, '0', 'Catalogo no participa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT_01', '1', 'CHF_CAT_NPT', NULL, '0', 1, '0', 'No desea que su casa participe en el estudio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT_02', '2', 'CHF_CAT_NPT', NULL, '0', 2, '0', 'Cambiará de Domicilio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT_03', '3', 'CHF_CAT_NPT', NULL, '0', 3, '0', 'No desean que sus niños sean muestreados');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT_04', '4', 'CHF_CAT_NPT', NULL, '0', 4, '0', 'No considera que tiene beneficios en el estudio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT_998', '998', 'CHF_CAT_NPT', NULL, '0', 5, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPP', NULL, NULL, NULL, '1', 0, '0', 'Catalogo no acepta tamizaje persona');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPP_01', '1', 'CHF_CAT_NPP', NULL, '0', 1, '0', 'No desea participar en el estudio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPP_02', '2', 'CHF_CAT_NPP', NULL, '0', 2, '0', 'Cambiará de Domicilio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPP_03', '3', 'CHF_CAT_NPP', NULL, '0', 3, '0', 'Tiene seguro médico');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPP_04', '4', 'CHF_CAT_NPP', NULL, '0', 4, '0', 'No considera que tiene beneficios en el estudio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPT_05', '5', 'CHF_CAT_NPP', NULL, '0', 5, '0', 'No desean que sus niños sean muestreados');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NPP_998', '998', 'CHF_CAT_NPP', NULL, '0', 6, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CI', NULL, NULL, NULL, '1', 0, '0', 'Catalogo criterios de inclusion');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CI_01', '1', 'CHF_CAT_CI', NULL, '0', 1, '0', '1) Vivir en área de cobertura del CSSFV.');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CI_02', '2', 'CHF_CAT_CI', NULL, '0', 2, '0', '2) Vivir en un hogar con al menos 1 niño/a menor de 12 años.');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CI_03', '3', 'CHF_CAT_CI', NULL, '0', 3, '0', '3) Tener la intención de permanecer en el área durante el estudio.');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CI_04', '4', 'CHF_CAT_CI', NULL, '0', 4, '0', '4) Tener una tarjeta de vacunación (niños/as) o un documento de identificación (adultos) para confirmar la edad y la residencia');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE', NULL, NULL, NULL, '1', 0, '0', 'Catalogo no acepta tamizaje persona');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_01', '1', 'CHF_CAT_DONDEASISTE', NULL, '0', 1, '0', 'Centro de Salud Sócrates Flores');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_02', '2', 'CHF_CAT_DONDEASISTE', NULL, '0', 2, '0', 'Otro centro de salud');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_03', '3', 'CHF_CAT_DONDEASISTE', NULL, '0', 3, '0', 'Puesto de Salud');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_04', '4', 'CHF_CAT_DONDEASISTE', NULL, '0', 4, '0', 'Hospital Público');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_05', '5', 'CHF_CAT_DONDEASISTE', NULL, '0', 5, '0', 'Médico Privado');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_06', '6', 'CHF_CAT_DONDEASISTE', NULL, '0', 6, '0', 'Seguro Social');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_07', '7', 'CHF_CAT_DONDEASISTE', NULL, '0', 7, '0', 'Curandero');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_08', '8', 'CHF_CAT_DONDEASISTE', NULL, '0', 8, '0', 'Farmacia');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DONDEASISTE_998', '998', 'CHF_CAT_DONDEASISTE', NULL, '0', 9, '0', 'Otro');


INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PUESTO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo puesto de salud');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PUESTO_01', '1', 'CHF_CAT_PUESTO', NULL, '0', 1, '0', 'P/S Cristo del Rosario');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PUESTO_02', '2', 'CHF_CAT_PUESTO', NULL, '0', 2, '0', 'P/S San Sebastian');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR', NULL, NULL, NULL, '1', 0, '0', 'Catalogo relacion familiar tutor');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR_01', '1', 'CHF_CAT_RFTUTOR', NULL, '0', 1, '0', 'Madre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR_02', '2', 'CHF_CAT_RFTUTOR', NULL, '0', 2, '0', 'Padre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR_03', '3', 'CHF_CAT_RFTUTOR', NULL, '0', 3, '0', 'Abuelo (a)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR_04', '4', 'CHF_CAT_RFTUTOR', NULL, '0', 4, '0', 'Tío (a)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR_05', '5', 'CHF_CAT_RFTUTOR', NULL, '0', 5, '0', 'Hermano (a)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RFTUTOR_998', '998', 'CHF_CAT_RFTUTOR', NULL, '0', 6, '0', 'Otra relación familiar');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIPO_PARTO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipos de parto CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIPO_PARTO_01', '1', 'CHF_CAT_TIPO_PARTO', NULL, '0', 1, '0', 'Vaginal / Natural');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIPO_PARTO_02', '2', 'CHF_CAT_TIPO_PARTO', NULL, '0', 2, '0', 'Cesárea');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIPO_PARTO_03', '3', 'CHF_CAT_TIPO_PARTO', NULL, '0', 4, '0', 'Rehusa contestar esta pregunta');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIPO_PARTO_999', '999', 'CHF_CAT_TIPO_PARTO', NULL, '0', 3, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DOC_MEDICO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipos de documentos médicos CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DOC_MEDICO_01', '1', 'CHF_CAT_DOC_MEDICO', NULL, '0', 1, '0', 'Control Prenatal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DOC_MEDICO_02', '2', 'CHF_CAT_DOC_MEDICO', NULL, '0', 2, '0', 'Tarjeta de Vacuna');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DOC_MEDICO_03', '3', 'CHF_CAT_DOC_MEDICO', NULL, '0', 3, '0', 'Epicrisis');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DOC_MEDICO_04', '4', 'CHF_CAT_DOC_MEDICO', NULL, '0', 4, '0', 'Expediente Clínico');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_DOC_MEDICO_998', '998', 'CHF_CAT_DOC_MEDICO', NULL, '0', 5, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SNDR', NULL, NULL, NULL, '1', 0, '0', 'Catalogo Si/No/Desconocido/Rehusa CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SNDR_01', '1', 'CHF_CAT_SNDR', NULL, '0', 1, '0', 'Si');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SNDR_02', '0', 'CHF_CAT_SNDR', NULL, '0', 2, '0', 'No');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SNDR_03', '2', 'CHF_CAT_SNDR', NULL, '0', 4, '0', 'Rehusa contestar esta pregunta');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SNDR_999', '999', 'CHF_CAT_SNDR', NULL, '0', 3, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SND', NULL, NULL, NULL, '1', 0, '0', 'Catalogo Si/No/Desconocido CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SND_01', '1', 'CHF_CAT_SND', NULL, '0', 1, '0', 'Si');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SND_02', '0', 'CHF_CAT_SND', NULL, '0', 2, '0', 'No');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_SND_999', '9', 'CHF_CAT_SND', NULL, '0', 3, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NIV_EDU', NULL, NULL, NULL, '1', 0, '0', 'Catalogo niveles de educación CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NIV_EDU_01', '1', 'CHF_CAT_NIV_EDU', NULL, '0', 1, '0', 'Ninguno');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NIV_EDU_02', '2', 'CHF_CAT_NIV_EDU', NULL, '0', 2, '0', 'Primaria');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NIV_EDU_03', '3', 'CHF_CAT_NIV_EDU', NULL, '0', 3, '0', 'Secundaria');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NIV_EDU_04', '4', 'CHF_CAT_NIV_EDU', NULL, '0', 4, '0', 'Técnico');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_NIV_EDU_05', '5', 'CHF_CAT_NIV_EDU', NULL, '0', 5, '0', 'Universitario');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TRABAJO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipos de trabajo CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TRABAJO_01', '1', 'CHF_CAT_TIP_TRABAJO', NULL, '0', 1, '0', 'Trabajo Formal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TRABAJO_02', '2', 'CHF_CAT_TIP_TRABAJO', NULL, '0', 2, '0', 'Trabajo Informal');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_GRD_EDU', NULL, NULL, NULL, '1', 0, '0', 'Catalogo grados escolares CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_GRD_EDU_01', '1', 'CHF_CAT_GRD_EDU', NULL, '0', 1, '0', 'Preescolar');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_GRD_EDU_02', '2', 'CHF_CAT_GRD_EDU', NULL, '0', 2, '0', 'Primaria');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_GRD_EDU_03', '3', 'CHF_CAT_GRD_EDU', NULL, '0', 3, '0', 'Secundaria');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_GRD_EDU_04', '4', 'CHF_CAT_GRD_EDU', NULL, '0', 4, '0', 'Universidad');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TURNO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo turnos de estudio CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TURNO_01', '1', 'CHF_CAT_TURNO', NULL, '0', 1, '0', 'AM');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TURNO_02', '2', 'CHF_CAT_TURNO', NULL, '0', 2, '0', 'PM');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CUIDAN_NINO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo dónde cuidad al niño si no va a la escuela CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CUIDAN_NINO_01', '1', 'CHF_CAT_CUIDAN_NINO', NULL, '0', 1, '0', 'CDI');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CUIDAN_NINO_02', '2', 'CHF_CAT_CUIDAN_NINO', NULL, '0', 2, '0', 'Vecino');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CUIDAN_NINO_03', '3', 'CHF_CAT_CUIDAN_NINO', NULL, '0', 3, '0', 'En su casa');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_CUIDAN_NINO_998', '998', 'CHF_CAT_CUIDAN_NINO', NULL, '0', 4, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_VIVE_NINO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo con quién vive el niño CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_VIVE_NINO_01', '1', 'CHF_CAT_VIVE_NINO', NULL, '0', 1, '0', 'Madre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_VIVE_NINO_02', '2', 'CHF_CAT_VIVE_NINO', NULL, '0', 2, '0', 'Padre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_VIVE_NINO_03', '3', 'CHF_CAT_VIVE_NINO', NULL, '0', 3, '0', 'Ambos');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_VIVE_NINO_998', '998', 'CHF_CAT_VIVE_NINO', NULL, '0', 4, '0', 'Otro');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_FUMA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo frecuencia de uso cocina de lenia CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_FUMA_01', '1', 'CHF_CAT_FREC_FUMA', NULL, '0', 1, '0', 'Diariamente');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_FUMA_02', '2', 'CHF_CAT_FREC_FUMA', NULL, '0', 2, '0', 'No diario');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_FUMA_03', '3', 'CHF_CAT_FREC_FUMA', NULL, '0', 3, '0', 'Semanalmente');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_FUMA_04', '4', 'CHF_CAT_FREC_FUMA', NULL, '0', 4, '0', 'Mensualmente');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FREC_FUMA_05', '5', 'CHF_CAT_FREC_FUMA', NULL, '0', 5, '0', 'De vez en cuando');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES', NULL, NULL, NULL, '1', 0, '0', 'Catalogo meses del año CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_01', '01', 'CHF_CAT_MESES', NULL, '0', 1, '0', 'Enero');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_02', '02', 'CHF_CAT_MESES', NULL, '0', 2, '0', 'Febrero');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_03', '03', 'CHF_CAT_MESES', NULL, '0', 3, '0', 'Marzo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_04', '04', 'CHF_CAT_MESES', NULL, '0', 4, '0', 'Abril');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_05', '05', 'CHF_CAT_MESES', NULL, '0', 5, '0', 'Mayo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_06', '06', 'CHF_CAT_MESES', NULL, '0', 6, '0', 'Junio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_07', '07', 'CHF_CAT_MESES', NULL, '0', 7, '0', 'Julio');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_08', '08', 'CHF_CAT_MESES', NULL, '0', 8, '0', 'Agosto');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_09', '09', 'CHF_CAT_MESES', NULL, '0', 9, '0', 'Septiembre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_10', '10', 'CHF_CAT_MESES', NULL, '0', 10, '0', 'Octubre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_11', '11', 'CHF_CAT_MESES', NULL, '0', 11, '0', 'Noviembre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_MESES_12', '12', 'CHF_CAT_MESES', NULL, '0', 12, '0', 'Diciembre');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_EXCLU', NULL, NULL, NULL, '1', 0, '0', 'Catalogo almentacion exclusiva CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_EXCLU_01', '1', 'CHF_CAT_EXCLU', NULL, '0', 1, '0', 'Exclusivamente');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_EXCLU_02', '2', 'CHF_CAT_EXCLU', NULL, '0', 2, '0', 'No Exclusivamente');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIEMPECHO', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tiempo dio el pecho CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIEMPECHO_01', '1', 'CHF_CAT_TIEMPECHO', NULL, '0', 1, '0', 'Menos de un mes o un mes');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIEMPECHO_02', '2', 'CHF_CAT_TIEMPECHO', NULL, '0', 2, '0', 'Numero de meses (02- 36)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIEMPECHO_03', '3', 'CHF_CAT_TIEMPECHO', NULL, '0', 3, '0', 'Aun se lo da');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIEMPECHO_999', '999', 'CHF_CAT_TIEMPECHO', NULL, '0', 4, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FORM_ALIM', NULL, NULL, NULL, '1', 0, '0', 'Catalogo forma de alimentar nino CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FORM_ALIM_01', '1', 'CHF_CAT_FORM_ALIM', NULL, '0', 1, '0', 'Lo alimenta con más leche materna que otro tipo de leche u otros alimentos');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FORM_ALIM_02', '2', 'CHF_CAT_FORM_ALIM', NULL, '0', 2, '0', 'Lo alimenta con más alimentos u otros tipos de leche, que leche materna');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_FORM_ALIM_03', '3', 'CHF_CAT_FORM_ALIM', NULL, '0', 3, '0', 'Lo alimenta igual con leche materna u otro tipo de leche o alimentos');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_EXC', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tiempo le dio el pecho para alimentar exclusivamente CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_EXC_01', '1', 'CHF_CAT_ALIM_EXC', NULL, '0', 1, '0', 'Un mes o menos');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_EXC_02', '2', 'CHF_CAT_ALIM_EXC', NULL, '0', 2, '0', 'Numero de meses (02- 36)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_EXC_999', '999', 'CHF_CAT_ALIM_EXC', NULL, '0', 4, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OTRA_ALIM', NULL, NULL, NULL, '1', 0, '0', 'Catalogo otro tipo de alimentación le da o le dio a su bebe CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OTRA_ALIM_01', '1', 'CHF_CAT_OTRA_ALIM', NULL, '0', 1, '0', 'Leche distinto a la leche de pecho (incluyendo formula, leche en polvo, leche liquida)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OTRA_ALIM_02', '2', 'CHF_CAT_OTRA_ALIM', NULL, '0', 2, '0', 'Líquidos distinto a leche (incluyendo aguas, refrescos, juegos, te)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OTRA_ALIM_03', '3', 'CHF_CAT_OTRA_ALIM', NULL, '0', 3, '0', '	Alimentos sólidos (atoles, pures, cereales, caldos con frijoles, arroz, sopa o verduras o cualquier otro alimento)');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DLP', NULL, NULL, NULL, '1', 0, '0', 'Catalogo edad comenzó a darle líquidos distintos a la leche de pecho CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DLP_01', '1', 'CHF_CAT_ALIM_DLP', NULL, '0', 1, '0', 'Meses (0-24)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DLP_02', '2', 'CHF_CAT_ALIM_DLP', NULL, '0', 2, '0', 'Aun no le da dado ningún líquido a parte de la leche de pecho');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DLP_999', '999', 'CHF_CAT_ALIM_DLP', NULL, '0', 3, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DL', NULL, NULL, NULL, '1', 0, '0', 'Catalogo edad comenzó a darle líquidos distintos a la leche CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DL_01', '1', 'CHF_CAT_ALIM_DL', NULL, '0', 1, '0', 'Meses (0-36)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DL_02', '2', 'CHF_CAT_ALIM_DL', NULL, '0', 2, '0', 'Aun no le da dado ningún líquido a parte de la leche de pecho');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_DL_999', '999', 'CHF_CAT_ALIM_DL', NULL, '0', 3, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_SOL', NULL, NULL, NULL, '1', 0, '0', 'Catalogo edad comenzó a darle alimentos sólidos CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_SOL_01', '1', 'CHF_CAT_ALIM_SOL', NULL, '0', 1, '0', 'Meses (0-36)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_SOL_02', '2', 'CHF_CAT_ALIM_SOL', NULL, '0', 2, '0', 'Aun no le da alimentos sólidos');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_ALIM_SOL_999', '999', 'CHF_CAT_ALIM_SOL', NULL, '0', 3, '0', 'Desconocido');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PROP_MX', NULL, NULL, NULL, '1', 0, '0', 'Catalogo propósito toma de muestra CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PROP_MX_01', '1', 'CHF_CAT_PROP_MX', NULL, '0', 1, '0', 'Muestreo anual');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PROP_MX_02', '2', 'CHF_CAT_PROP_MX', NULL, '0', 2, '0', 'Muestra enfermo');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP0_MX', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipos de muestra CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP0_MX_01', '1', 'CHF_CAT_TIP0_MX', NULL, '0', 1, '0', 'Sangre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP0_MX_02', '2', 'CHF_CAT_TIP0_MX', NULL, '0', 2, '0', 'Hisopado Faringeo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP0_MX_03', '3', 'CHF_CAT_TIP0_MX', NULL, '0', 3, '0', 'Hisopado Nasal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP0_MX_04', '4', 'CHF_CAT_TIP0_MX', NULL, '0', 4, '0', 'Lavado Nasal');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TUBO_MX', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipos de tubos muestras CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TUBO_MX_01', '1', 'CHF_CAT_TIP_TUBO_MX', NULL, '0', 1, '0', 'Rojo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TUBO_MX_02', '2', 'CHF_CAT_TIP_TUBO_MX', NULL, '0', 2, '0', 'BHC');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_TIP_TUBO_MX_03', '3', 'CHF_CAT_TIP_TUBO_MX', NULL, '0', 3, '0', 'PBMC');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX', NULL, NULL, NULL, '1', 0, '0', 'Catalogo razón no se toma muestra CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX_01', '1', 'CHF_CAT_RAZON_NO_MX', NULL, '0', 1, '0', 'Muestra difícil');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX_02', '2', 'CHF_CAT_RAZON_NO_MX', NULL, '0', 2, '0', 'Se descanalizó');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX_03', '3', 'CHF_CAT_RAZON_NO_MX', NULL, '0', 3, '0', 'Se pinchó mas de 2 veces');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX_04', '4', 'CHF_CAT_RAZON_NO_MX', NULL, '0', 4, '0', 'Padre/niño no aceptó tomar muestra');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX_05', '5', 'CHF_CAT_RAZON_NO_MX', NULL, '0', 5, '0', 'Padre o tutor después de pinchadazo no desea que se le tome mx al niño');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_RAZON_NO_MX_998', '998', 'CHF_CAT_RAZON_NO_MX', NULL, '0', 6, '0', 'Otra razon');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OBSERV_MX', NULL, NULL, NULL, '1', 0, '0', 'Catalogo observaciones toma muestra CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OBSERV_MX_01', '1', 'CHF_CAT_OBSERV_MX', NULL, '0', 1, '0', 'Muestra difícil');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OBSERV_MX_02', '2', 'CHF_CAT_OBSERV_MX', NULL, '0', 2, '0', 'Ninguna');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_OBSERV_MX_998', '998', 'CHF_CAT_OBSERV_MX', NULL, '0', 3, '0', 'Otra razon');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PINCH_MX', NULL, NULL, NULL, '1', 0, '0', 'Catalogo tipos de muestra CHF');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PINCH_MX_01', '0', 'CHF_CAT_PINCH_MX', NULL, '0', 1, '0', '0');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PINCH_MX_02', '1', 'CHF_CAT_PINCH_MX', NULL, '0', 2, '0', '1');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PINCH_MX_03', '2', 'CHF_CAT_PINCH_MX', NULL, '0', 3, '0', '2');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PINCH_MX_04', '3', 'CHF_CAT_PINCH_MX', NULL, '0', 4, '0', '3');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('CHF_CAT_PINCH_MX_05', '4', 'CHF_CAT_PINCH_MX', NULL, '0', 5, '0', '4');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_FUMIGA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo frecuencia fumigación Seroprevalencia Arbovirus (SA)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_FUMIGA_01', '1', 'SA_CAT_FUMIGA', NULL, '0', 1, '0', 'Semanal');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_FUMIGA_02', '2', 'SA_CAT_FUMIGA', NULL, '0', 2, '0', 'Mensual');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_FUMIGA_03', '3', 'SA_CAT_FUMIGA', NULL, '0', 3, '0', 'Cada 6 Meses');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_FUMIGA_04', '4', 'SA_CAT_FUMIGA', NULL, '0', 4, '0', 'Una Vez al Año');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_RELFAM', NULL, NULL, NULL, '1', 0, '0', 'Catalogo realación familiar SA');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_RELFAM_01', '1', 'SA_CAT_RELFAM', NULL, '0', 1, '0', 'Pareja');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_RELFAM_02', '2', 'SA_CAT_RELFAM', NULL, '0', 2, '0', 'Hijo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_RELFAM_03', '3', 'SA_CAT_RELFAM', NULL, '0', 3, '0', 'Padres');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_RELFAM_04', '4', 'SA_CAT_RELFAM', NULL, '0', 4, '0', 'Amigo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_RELFAM_998', '998', 'SA_CAT_RELFAM', NULL, '0', 5, '0', 'Otra relacion familiar');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo definición zika SA');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA_01', '1', 'SA_CAT_DEF_ZIKA', NULL, '0', 1, '0', 'Virus');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA_02', '2', 'SA_CAT_DEF_ZIKA', NULL, '0', 2, '0', 'Bacteria');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA_03', '3', 'SA_CAT_DEF_ZIKA', NULL, '0', 3, '0', 'Una enfermedad');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA_04', '4', 'SA_CAT_DEF_ZIKA', NULL, '0', 4, '0', 'Mosquito');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA_05', '5', 'SA_CAT_DEF_ZIKA', NULL, '0', 5, '0', 'Fiebre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_DEF_ZIKA_998', '998', 'SA_CAT_DEF_ZIKA', NULL, '0', 6, '0', 'Otra');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_TRA_ZIKA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo transmisión de zika SA');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_TRA_ZIKA_01', '1', 'SA_CAT_TRA_ZIKA', NULL, '0', 1, '0', 'Mosquito');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_TRA_ZIKA_02', '2', 'SA_CAT_TRA_ZIKA', NULL, '0', 2, '0', 'Sexual');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_TRA_ZIKA_03', '3', 'SA_CAT_TRA_ZIKA', NULL, '0', 3, '0', 'Besos/Saliva');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_TRA_ZIKA_04', '4', 'SA_CAT_TRA_ZIKA', NULL, '0', 4, '0', 'Contacto de piel');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_TRA_ZIKA_998', '998', 'SA_CAT_TRA_ZIKA', NULL, '0', 5, '0', 'Otra');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS', NULL, NULL, NULL, '1', 0, '0', 'Catalogo síntomas SA');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS_01', '1', 'SA_CAT_SINTOMAS', NULL, '0', 1, '0', 'Rash');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS_02', '2', 'SA_CAT_SINTOMAS', NULL, '0', 2, '0', 'Fiebre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS_03', '3', 'SA_CAT_SINTOMAS', NULL, '0', 3, '0', 'Ojos rojos (conjunctivitis)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS_04', '4', 'SA_CAT_SINTOMAS', NULL, '0', 4, '0', 'Dolor de hueso (arthralgia)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS_05', '5', 'SA_CAT_SINTOMAS', NULL, '0', 5, '0', 'Dolor de músculos( myalgia)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINTOMAS_06', '6', 'SA_CAT_SINTOMAS', NULL, '0', 6, '0', 'Inflamación  (peri-articular edema)');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo síntomas de zika SA');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_01', '1', 'SA_CAT_SINT_ZIKA', NULL, '0', 1, '0', 'Rash');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_02', '2', 'SA_CAT_SINT_ZIKA', NULL, '0', 2, '0', 'Fiebre');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_03', '3', 'SA_CAT_SINT_ZIKA', NULL, '0', 3, '0', 'Ojos rojos (conjunctivitis)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_04', '4', 'SA_CAT_SINT_ZIKA', NULL, '0', 4, '0', 'Dolor de hueso (arthralgia)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_05', '5', 'SA_CAT_SINT_ZIKA', NULL, '0', 5, '0', 'Dolor de músculos( myalgia)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_06', '6', 'SA_CAT_SINT_ZIKA', NULL, '0', 6, '0', 'Inflamación  (peri-articular edema)');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_07', '7', 'SA_CAT_SINT_ZIKA', NULL, '0', 7, '0', 'Diarrea');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_08', '8', 'SA_CAT_SINT_ZIKA', NULL, '0', 8, '0', 'Dolor de cabeza');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_09', '9', 'SA_CAT_SINT_ZIKA', NULL, '0', 9, '0', 'Dolor de estómago');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_10', '10', 'SA_CAT_SINT_ZIKA', NULL, '0', 10, '0', 'Dolor de garganta');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_11', '11', 'SA_CAT_SINT_ZIKA', NULL, '0', 11, '0', 'Mocos');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_SINT_ZIKA_12', '12', 'SA_CAT_SINT_ZIKA', NULL, '0', 12, '0', 'Toz');

INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA', NULL, NULL, NULL, '1', 0, '0', 'Catalogo lugares ha visto larvas de zika SA');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_01', '1', 'SA_CAT_LUG_LARVA', NULL, '0', 1, '0', 'Barriles');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_02', '2', 'SA_CAT_LUG_LARVA', NULL, '0', 2, '0', 'Floreros');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_03', '3', 'SA_CAT_LUG_LARVA', NULL, '0', 3, '0', 'Botellas');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_04', '4', 'SA_CAT_LUG_LARVA', NULL, '0', 4, '0', 'Botellas de vidrio quebrada');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_05', '5', 'SA_CAT_LUG_LARVA', NULL, '0', 5, '0', 'Platas');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_06', '6', 'SA_CAT_LUG_LARVA', NULL, '0', 6, '0', 'Canales de techo');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_998', '998', 'SA_CAT_LUG_LARVA', NULL, '0', 7, '0', 'Otros lugares');
INSERT INTO `mensajes` (`messageKey`, `catKey`, `catRoot`, `en`, `isCat`, `orden`, `catPasive`, `es`) VALUES ('SA_CAT_LUG_LARVA_07', '7', 'SA_CAT_LUG_LARVA', NULL, '0', 8, '0', 'No ha visto');
