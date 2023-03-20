INSERT into GENERAL_ADMINS (username, password) values ('gadmin', '$2a$10$p3Q7uAuj6J.wM15xVL/QAeVOtLEy0HShtsqSRILTlOOVrxtLe50d6');

INSERT INTO PLATFORM_USERS ( email, first_name, last_name, password, postcode, username, AUTHENTICATION_TYPE )
VALUES ( 'cadmin@localhost', 'cadmin', 'cadmin', '$2a$10$Us28KZ6IEZobDd3ZIkQ9kudH0BssiIpjhGlHWN/YuE761XKw8krIS',
         '6857','cadmin' , 0),
       ( 'moderator@localhost', 'moderator', 'moderator',
         '$2a$10$NL4iJdBptEYYDnsYvKaIW.7kPQNmi2ZQD9WZQ81VD2ETmpRVULrfS',
         '8678675', 'moderator' , 0),
       ( 'member1@localhost', 'member1', 'member1', '$2a$10$TeFgOrKh3heqFwXOcFZ82OdQ8asTAr8krJydjgsAXvJc6kcYvFHZK',
         '23425', 'member1' , 0),
       ( 'member2@localhost', 'member2', 'member2', '$2a$10$0SEX6x9MVC24UkyFSgMmJeRvNXlXgBH.vmiBvRPOpNBExurHyzCuS',
         '89876', 'member2' , 0),
       ( 'moderator1@localhost', 'moderator1', 'moderator1',
         '$2a$12$fqJRfbx7TOIIPoyERKII4OTkuz1Wf3ZDCOyHZc3CVPGpkP601Pnv.',
         '123123', 'moderator1' , 0);

INSERT INTO youth_councils ( council_name, description, is_after_election, municipality )
VALUES ('my_youthcouncil', 'my youthcouncil description', 'false', 'my_municipality' );

INSERT INTO THEMES(THEME) VALUES ('Road Safety');

INSERT INTO SUB_THEMES(SUB_THEME, SUPER_THEME_THEME_ID) VALUES ('Safety at intersection X', 1);

INSERT INTO MEDIA(MEDIA_TYPE_DISCR, MEDIA_TYPE, PATH) VALUES ('Video',  0, 'my/video/1'), ('Image', 1, 'my/image/1');



/*
INSERT INTO youthcouncil_council_admins
VALUES ( 1, 2 );
INSERT INTO youthcouncil_council_members
VALUES ( 1, 4 ), ( 1, 6 );

-- INFORMATIVE PAGES
INSERT INTO informative_pages ( is_enabled, title )
VALUES ( 'true', 'my_informative_page' );
INSERT INTO youthcouncil_informative_pages
VALUES ( 1, 1 );


-- ACTION POINTS
INSERT INTO module_items( module_item_type, description, is_default, is_enabled, title, label, image )
VALUES ( 'actionpoint', 'my action point description', 'false', 'true', 'my_action_point', 'NEW',
         'my/action/point/image ' );
INSERT INTO youthcouncil_module_items
VALUES ( 1, 1 );

*/

INSERT INTO ACTION_POINTS(description, is_active, is_default, status, title, owning_youth_council_youth_council_id, theme_theme_id, video_media_id)
VALUES ('my action point description', true, false, 0, 'my action point title', 1, 1, 1);


INSERT INTO YOUTH_COUNCILS_ACTION_POINTS(youth_council_youth_council_id, action_points_action_point_id) VALUES (1, 1);

INSERT INTO SHARES(interactable_type, item_shared, image_media_id, sharing_user) VALUES ('ActionPoint', 1, 2, 1);

INSERT INTO ACTION_POINTS_SHARES(action_point_action_point_id, shares_share_id) VALUES (1, 1);
/*

-- CALL FOR IDEA
INSERT INTO module_items( module_item_type, description, is_default, is_enabled, title, image )
VALUES ( 'call-for-idea', 'my call for idea description', 'false', 'true', 'my_call_for_idea',
         'my/call/for/idea/image ' );
INSERT INTO youthcouncil_module_items
VALUES ( 1, 2 );

-- NEWSFEED
INSERT INTO module_items( module_item_type, description, is_default, is_enabled, title, image )
VALUES ( 'announcement', 'my announcement description', 'false', 'true', 'my_announcement', 'my/announcement/image ' );
INSERT INTO youthcouncil_module_items
VALUES ( 1, 3 );


-- THEMES
INSERT INTO themes( theme )
VALUES ( 'road safety' );
INSERT INTO subthemes( sub_theme )
VALUES ( 'safety at intersection x' ),
       ( 'safety in area y' );

INSERT INTO themes_sub_themes
VALUES ( 1, 1 );*/