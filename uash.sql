
CREATE TABLE public.lavagem (
    lavagem_id integer NOT NULL,
    lavagem_hora timestamp without time zone,
    lavagem_loc character varying(255),
    lavagem_rat integer,
    lavagem_sta character varying(255),
    lavagem_tipo character varying(255),
    lavagem_val integer,
    lavagem_uasher integer,
    lavagem_veic integer
);


CREATE TABLE public.uasher (
    uasher_id integer NOT NULL,
    uasher_carta character varying(255),
    uasher_loc character varying(255),
    uasher_mat boolean,
    uasher_rat integer,
    uasher_user integer,
    user_uashers_fav integer
);



CREATE TABLE public.usuario (
    user_id integer NOT NULL,
    user_dt_nasc date,
    user_email character varying(255),
    user_loc character varying(255),
    user_nome character varying(255),
    user_pass character varying(255),
    user_tel integer
);


CREATE TABLE public.veiculo (
    veiculo_id integer NOT NULL,
    veiculo_loc character varying(255),
    veiculo_mat character varying(255),
    veiculo_tipo character varying(255)
);


CREATE TABLE public.veiculo_users (
    veiculo_veiculo_id integer NOT NULL,
    users_user_id integer NOT NULL
);



INSERT INTO public.lavagem (lavagem_id, lavagem_hora, lavagem_loc, lavagem_rat, lavagem_sta, lavagem_tipo, lavagem_val, lavagem_uasher, lavagem_veic) VALUES (1, NULL, NULL, 5, 'Concluído', 'Garagem Privada', 45, 2, 3);
INSERT INTO public.lavagem (lavagem_id, lavagem_hora, lavagem_loc, lavagem_rat, lavagem_sta, lavagem_tipo, lavagem_val, lavagem_uasher, lavagem_veic) VALUES (2, NULL, NULL, 0, 'Solicitado', 'Lavagem a Seco', 25, 1, 1);




INSERT INTO public.uasher (uasher_id, uasher_carta, uasher_loc, uasher_mat, uasher_rat, uasher_user, user_uashers_fav) VALUES (1, '3098761/B', 'Cruz Quebrada', false, NULL, 1, NULL);
INSERT INTO public.uasher (uasher_id, uasher_carta, uasher_loc, uasher_mat, uasher_rat, uasher_user, user_uashers_fav) VALUES (2, '6547531/B', 'Santos', true, 5, 3, NULL);
INSERT INTO public.uasher (uasher_id, uasher_carta, uasher_loc, uasher_mat, uasher_rat, uasher_user, user_uashers_fav) VALUES (3, '2069739/B', 'Lisboa', true, 3, 5, NULL);



INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (1, '1997-03-15', 'nutellaking@gmail.com', 'Cruz Quebrada', 'Alexandre Carvalho', '6823cc2d4ac2e848a53f64', 910599351);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (2, '2000-09-27', 'irissantos24@yahoo.com', 'Algés', 'Íris Ferreira Santos', 'd59849704e18653cb6a8', 910378312);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (3, '1994-11-25', 'jocar45@hotmail.com', 'Santos', 'Joaquim Ramos', 'd59849704e18653cb6a8', 911415432);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (4, '2002-05-03', 'luiza_ara@gmail.com', 'Setubal', 'Luiza Araújo', 'f79559704r19753op3a5', 955030276);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (5, '2003-10-09', 'fran.bar@gmail.com', 'Lisboa', 'Francisco Barbosa', 'p98565664o19633rt3a2', 989001466);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (6, '1998-12-27', 'vitor_h_1998@gmail.com', 'Cascais', 'Vitor Hugo Moura', 'h98565951t15313df8s2', 960423115);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (7, '1978-01-07', 'carlos_eduardo@outlook.com', 'Lisboa', 'Carlos Eduardo Cunha', 'm65565951p15313df8d8', 930600835);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (8, '1992-06-06', 'lara_das_neves11@hotmail.com', 'Santos', 'Lara das Neves', 'l385984951b18523kk8f6', 916377555);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (9, '1996-11-07', 'emanu.p@gmail.com', 'Alcantara', 'Emanuel Porto', 'k35943951c18523vc8t9', 986066979);
INSERT INTO public.usuario (user_id, user_dt_nasc, user_email, user_loc, user_nome, user_pass, user_tel) VALUES (10, '2001-07-20', 'luiz-mig-ara@gmail.com', 'Marvila', 'Luiz Miguel Araújo', 'p85243951d88523yc8r7', 986066979);



INSERT INTO public.veiculo (veiculo_id, veiculo_loc, veiculo_mat, veiculo_tipo) VALUES (1, 'Cruz Quebrada', '15VA73', 'Honda Civic 2003');
INSERT INTO public.veiculo (veiculo_id, veiculo_loc, veiculo_mat, veiculo_tipo) VALUES (2, 'Santos', '87CM11', 'Fiat Panda');
INSERT INTO public.veiculo (veiculo_id, veiculo_loc, veiculo_mat, veiculo_tipo) VALUES (3, 'Cruz Quebrada', '15VA73', 'Honda Civic 2003');




INSERT INTO public.veiculo_users (veiculo_veiculo_id, users_user_id) VALUES (2, 8);
INSERT INTO public.veiculo_users (veiculo_veiculo_id, users_user_id) VALUES (3, 1);




SELECT pg_catalog.setval('public.lavagem_lavagem_id_seq', 2, true);



SELECT pg_catalog.setval('public.uasher_uasher_id_seq', 3, true);


SELECT pg_catalog.setval('public.usuario_user_id_seq', 10, true);




SELECT pg_catalog.setval('public.veiculo_veiculo_id_seq', 3, true);



ALTER TABLE ONLY public.lavagem
    ADD CONSTRAINT lavagem_pkey 
    PRIMARY KEY (lavagem_id);



ALTER TABLE ONLY public.uasher
    ADD CONSTRAINT uasher_pkey 
    PRIMARY KEY (uasher_id);



ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey 
    PRIMARY KEY (user_id);



ALTER TABLE ONLY public.veiculo
    ADD CONSTRAINT veiculo_pkey 
    PRIMARY KEY (veiculo_id);



ALTER TABLE ONLY public.uasher
    ADD CONSTRAINT fk1ssv3j4qqk1i6h9g1ofd58hrr 
    FOREIGN KEY (user_uashers_fav) 
    REFERENCES public.usuario(user_id);



ALTER TABLE ONLY public.lavagem
    ADD CONSTRAINT fk2t37p5lnfm78dal884soccmkh 
    FOREIGN KEY (lavagem_uasher) 
    REFERENCES public.uasher(uasher_id);



ALTER TABLE ONLY public.lavagem
    ADD CONSTRAINT fk7bgn910is69lwfclf9a56xx4p 
    FOREIGN KEY (lavagem_veic) 
    REFERENCES public.veiculo(veiculo_id);



ALTER TABLE ONLY public.veiculo_users
    ADD CONSTRAINT fkh3ilsjlk4gqq3gj3brgs1s4ol 
    FOREIGN KEY (veiculo_veiculo_id) 
    REFERENCES public.veiculo(veiculo_id);



ALTER TABLE ONLY public.uasher
    ADD CONSTRAINT fki5301tw5aovmj1bhykmm2rdov 
    FOREIGN KEY (uasher_user) 
    REFERENCES public.usuario(user_id);



ALTER TABLE ONLY public.veiculo_users
    ADD CONSTRAINT fkrk66ra39qhr7n8yfqeqa3clt2 
    FOREIGN KEY (users_user_id) 
    REFERENCES public.usuario(user_id);





