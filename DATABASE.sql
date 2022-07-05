create database JunkBox;
use JunkBox;
----------------------------------------------------- user table ---------------------------------------------------------------------------------------------
create table UserDetail
(
userId char(25) not null primary key,
Pass varchar(25) not null,
uName char(25) not null, 
mobile bigint not null
);
delete from UserDetail where userId='123456';
select * from UserDetail;


-- Play List  ---------------------------------------------------------------------------------------------

 create table playlistDetail
 (
 playId char(25) not null primary key,
 songName char(25) not null,
 podName char(25) not null,
 playlistName char(25) not null,
 foreign key(playlistName) references playlist(playlistName) ON DELETE CASCADE on update cascade,
 foreign key(songName) references songs(songNmae) ON DELETE CASCADE  ,
 foreign key(podName) references podcast(podName) ON DELETE CASCADE on update cascade
 );
 -- drop table playlistDetail;
select * from playlistDetail;
 ----------------------------------------------------- Play List Detail table ------------------------------------------------------------------------------------------


 create table playlist
(
playlistName char(25) not null primary key,
userId char(25) not null,
FOREIGN KEY (userId) REFERENCES UserDetail(userId) ON DELETE CASCADE on update cascade
);
-- drop table playlist;

select * from playlist;


 -------------------------------------------------------- Song table -------------------------------------------------------------------------------------------------
 
 create table songs
 (
 userId char(25) not null,
 songNmae char(25) not null primary key,
 genre char(25) not null,
 duration time not null,
 filepath varchar(80) not null,
 FOREIGN KEY (userId) REFERENCES UserDetail(userId) ON DELETE CASCADE on update cascade
 );
select filepath from songs;
--- drop table songs; ---
 -------------------------------------------------------- Podcast Table ----------------------------------------------------------------------------------------------
 
 create table podcast
 (
 userId char(25) not null,
 podName char(25) not null primary key,
 genre char(25) not null,
 episode char(22) not null,
 filepath varchar(80) not null,
  FOREIGN KEY (userId) REFERENCES UserDetail(userId) ON DELETE CASCADE
  );
  delete from podcast where podName = 'Good_Life';
--  drop table podcast; ----
  select * from playlist;
    select * from playlistDetail;
      select * from userDetail;
      --     //F:\Java course\MyJunkBox\src\main\resources\songs\Alive.wav
     --   //F:\Java course\MyJunkBox\src\main\resources\songs\Animals (Original Mix).wav
     --   //F:\Java course\MyJunkBox\src\main\resources\songs\Get Low.wav
insert into podcast values('2202','Daily_Habit','Social_Issue','EP02','F:\\Java course\\MyJunkBox\\src\\main\\resources\\Podcast\\Top 3 Daily Habits.wav');
        select * from songs;
          select * from podcast;