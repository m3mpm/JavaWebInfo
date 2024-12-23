-- start create tables

CREATE TABLE Peers (
    nickname varchar UNIQUE primary key,
    birthday date not null
);

CREATE TABLE Tasks (
    title varchar primary key UNIQUE DEFAULT NULL,
    parentTask varchar DEFAULT NULL, constraint FK_Tasks_ParentTask foreign key (title) references Tasks(title),
    maxXP integer not null
);

CREATE TYPE check_status AS ENUM ('Start', 'Success', 'Failure');

CREATE TABLE Checks (
    id serial primary key,
    peer varchar, constraint fk_Checks_checkingPeer foreign key (peer) references Peers(nickname),
    task varchar, constraint fk_Checks_Peer_title foreign key (task) references Tasks(title),
    "date" date
);

CREATE TABLE P2P (
     id serial primary key,
     "check" bigint, constraint fk_P2P_check foreign key ("check") references Checks(id),
     checkingPeer varchar, constraint fk_P2P_checkingPeer foreign key (checkingPeer) references Peers(nickname),
     state check_status,
     "time" TIME without time zone
);

CREATE TABLE Verter (
    id serial primary key,
    "check" bigint, constraint fk_Verter_check foreign key ("check") references Checks(id),
    state check_status,
    "time" TIME without time zone
);

CREATE TABLE TransferredPoints (
    id serial primary key,
    checkingPeer varchar, constraint fk_TransferredPoints_checkingPeer foreign key (checkingPeer) references Peers(nickname),
    checkedPeer varchar, constraint fk_TransferredPoints_checkedPeer foreign key (checkedPeer) references Peers(nickname),
    pointsAmount integer
);

CREATE TABLE Friends (
    id serial primary key,
    peer1 varchar not null, constraint fk_Friends_Peer1 foreign key (peer1) references Peers(nickname),
    peer2 varchar not null, constraint fk_Friends_Peer2 foreign key (peer2) references Peers(nickname)
);

CREATE TABLE Recommendations (
    id serial primary key,
    peer varchar, constraint fk_Recommendations_Peer foreign key (peer) references Peers(nickname),
    recommendedPeer varchar, constraint fk_Recommendations_RecommendedPeer foreign key (recommendedPeer) references Peers(nickname)
);

CREATE TABLE XP (
    id serial primary key,
    "check" bigint, constraint fk_XP_check foreign key ("check") references Checks(id),
    xpAmount integer
);

CREATE TYPE time_status AS ENUM ('1', '2');

CREATE TABLE TimeTracking (
    id serial primary key,
    peer varchar, constraint fk_TimeTracking_Peer foreign key (peer) references Peers(nickname),
    "date" date,
    "time" TIME without time zone,
    state time_status
);

-- end create tables

-- procedures for import data into tables from csv files and export data from tables to csv files
CREATE OR REPLACE FUNCTION fnc_get_columns_names(tablename text) RETURNS TEXT AS $BODY$
    BEGIN
        RETURN (SELECT string_agg(format('%s', quote_ident(column_name)), ',' ) FROM ( SELECT column_name
                                                                                       FROM information_schema.columns
                                                                                       WHERE table_schema='public' AND table_name = tablename
                                                                                         AND NOT column_name = 'id') AS names);
    END
$BODY$ LANGUAGE plpgsql;;

-- CREATE OR REPLACE PROCEDURE pr_fill_table_from_csv(IN tablename text,IN path text,IN delim text)
-- LANGUAGE plpgsql as $$
-- BEGIN
-- -- чтобы в файлах не надо было руками заполнять столбец id, при заполнении таблицы перечисляем список столбцов кроме id
-- EXECUTE format('COPY %1$s(%4$s) FROM %2$L WITH DELIMITER ''%3$s'' CSV HEADER', $1, $2, $3, fnc_get_columns_names(tablename));
-- -- проверка что есть колонка id в таблице
-- IF exists ( SELECT 1
--             FROM information_schema.columns
--             WHERE table_schema='public' AND table_name = tablename
--               AND column_name='id')
-- THEN
--     EXECUTE format('SELECT setval(''%1$s_id_seq'', (SELECT MAX(id) FROM %1$s));', $1); -- сброс счетчика на текущее max(id)
-- END IF;
-- END;$$;
--
-- CREATE OR REPLACE PROCEDURE pr_fill_csv_from_table(IN tablename text,IN path text,IN delim text)
-- LANGUAGE plpgsql AS $$
-- BEGIN
-- EXECUTE format('COPY %s TO %L DELIMITER ''%s'' CSV HEADER;', $1, $2, $3);
-- END;$$;
-- end procedures for import data into tables from csv files and export data from tables to csv files



-- SET path_to_src.var TO '/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/';
-- CALL pr_fill_table_from_csv('peers','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/peers.csv',',');
-- CALL pr_fill_table_from_csv('tasks','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/tasks.csv',',');
-- CALL pr_fill_table_from_csv('checks','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/checks.csv',',');
-- CALL pr_fill_table_from_csv('p2p','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/p2p.csv',',');
-- CALL pr_fill_table_from_csv('verter','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/verter.csv',',');
-- CALL pr_fill_table_from_csv('xp','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/xp.csv',',');
-- CALL pr_fill_table_from_csv('friends','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/friends.csv',',');
-- CALL pr_fill_table_from_csv('recommendations','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/recommendations.csv',',');
-- CALL pr_fill_table_from_csv('timetracking','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/timetracking.csv',',');
-- CALL pr_fill_table_from_csv('transferredpoints','/Users/zgeorgan/Documents/projects/github/JavaWebInfo/src/main/resources/database/import/transferredpoints.csv',',');



-- procedures for import data into tables from csv files and export data from tables to csv files
-- CREATE OR REPLACE FUNCTION fnc_get_columns_names(tablename text)
-- RETURNS TEXT AS
-- '
-- BEGIN
-- RETURN (SELECT string_agg(format(''%s'', quote_ident(column_name)), '','' ) FROM ( SELECT column_name
--                                                                                FROM information_schema.columns
--                                                                                WHERE table_schema=''public'' AND table_name = tablename
--                                                                                  AND NOT column_name = ''id'') AS names);
-- END;
-- '   LANGUAGE plpgsql;
--
--
-- CREATE OR REPLACE PROCEDURE pr_fill_table_from_csv(IN tablename text,IN path text,IN delim text)
-- LANGUAGE plpgsql as '
-- BEGIN
--
-- EXECUTE format(''COPY %1$s(%4$s) FROM %2$L WITH DELIMITER %3$s CSV HEADER'', $1, $2, $3, fnc_get_columns_names(tablename));
--
-- IF exists ( SELECT 1
--             FROM information_schema.columns
--             WHERE table_schema=''public'' AND table_name = tablename
--               AND column_name=''id'')
-- THEN
--     EXECUTE format(''SELECT setval(%1$s_id_seq, (SELECT MAX(id) FROM %1$s));'', $1);
-- END IF;
-- END;';

-- end procedures for import data into tables from csv files and export data from tables to csv files
