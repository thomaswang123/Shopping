/*y用户数据*/
insert into user values (1001,123456,123456);
insert into user values (1002,654321,123456);
insert into user values (1003,65432144,123456);
insert into user values (1004,65432122,123456);
insert into user values (1005,123456,123456);
insert into user values (1006,654321,123456);
insert into user values (1007,65432144,123456);
insert into user values (1008,65432122,123456);
insert into user values (1009,123456,123456);
insert into user values (1010,654321,123456);
insert into user values (1011,65432144,123456);
insert into user values (1012,65432122,123456);
insert into user values (1013,123456,123456);
insert into user values (1014,654321,123456);
insert into user values (1015,65432144,123456);
insert into user values (1016,65432122,123456);

/*用户基本信息数据*/
insert into userinfo values(1001,'哈哈','男',18,'12313245658','湖南长沙');
insert into userinfo values(1002,'哼哼','男',19,'12312312465','湖南长沙');
insert into userinfo values(1003,'哈哈一','男',18,'46546718798','湖南株洲');
insert into userinfo values(1004,'哼哼二','男',19,'12311879812','湖南湘潭');

insert into userinfo values(1005,'哈哈','男',18,'12313245658','湖南长沙');
insert into userinfo values(1006,'哼哼','男',19,'12312312465','湖南长沙');
insert into userinfo values(1007,'哈哈一','男',18,'46546718798','湖南株洲');
insert into userinfo values(1008,'哼哼二','男',19,'12311879812','湖南湘潭');

insert into userinfo values(1009,'哈哈','男',18,'12313245658','湖南长沙');
insert into userinfo values(1010,'哼哼','男',19,'12312312465','湖南长沙');
insert into userinfo values(1011,'哈哈一','男',18,'46546718798','湖南株洲');
insert into userinfo values(1012,'哼哼二','男',19,'12311879812','湖南湘潭');

insert into userinfo values(1013,'哈哈','男',18,'12313245658','湖南长沙');
insert into userinfo values(1014,'哼哼','男',19,'12312312465','湖南长沙');
insert into userinfo values(1015,'哈哈一','男',18,'46546718798','湖南株洲');
insert into userinfo values(1016,'哼哼二','男',19,'12311879812','湖南湘潭');
update userinfo set uinfo_phone =12311879812 where uinfo_id = 1004;

/*管理员*/
insert into admin values(1001,3);
insert into admin values(1002,3);
insert into admin values(1003,1);
insert into admin values(1004,1);
insert into admin values(1005,3);
insert into admin values(1006,3);
insert into admin values(1007,1);
insert into admin values(1008,1);
insert into admin values(1009,3);
insert into admin values(1010,3);
insert into admin values(1011,1);
insert into admin values(1012,1);
insert into admin values(1013,3);
insert into admin values(1014,3);
insert into admin values(1015,1);
insert into admin values(1016,1);

/*钱包*/
insert into wallet values(1001,99999.9,123456);
insert into wallet values(1002,99999.9,123456);
insert into wallet values(1003,99999.9,123456);
insert into wallet values(1004,99999.9,123456);
insert into wallet values(1005,99999.9,123456);
insert into wallet values(1006,99999.9,123456);
insert into wallet values(1007,99999.9,123456);
insert into wallet values(1008,99999.9,123456);
insert into wallet values(1009,99999.9,123456);
insert into wallet values(1010,99999.9,123456);
insert into wallet values(1011,99999.9,123456);
insert into wallet values(1012,99999.9,123456);
insert into wallet values(1013,99999.9,123456);
insert into wallet values(1014,99999.9,123456);
insert into wallet values(1015,99999.9,123456);
insert into wallet values(1016,99999.9,123456);

/*密保*/
insert  into passwordprotection values(2001,1001,'你自己的姓名','哈哈');
insert  into passwordprotection values(2002,1001,'你最好的朋友姓名','啊哈哈');
insert  into passwordprotection values(2003,1001,'你最好异性名字','哦哈哈');

insert  into passwordprotection values(2004,1002,'你自己的姓名','哼哼');
insert  into passwordprotection values(2005,1002,'你最好的朋友姓名','啊哼哼');
insert  into passwordprotection values(2006,1002,'你最好异性名字','哦哼哼');

insert  into passwordprotection values(2007,1003,'你自己的姓名','一哈哈');
insert  into passwordprotection values(2008,1003,'你最好的朋友姓名','哈哈一');
insert  into passwordprotection values(2009,1003,'你最好异性名字','哈一哈');


insert  into passwordprotection values(2010,1004,'你自己的姓名','一哼哼');
insert  into passwordprotection values(2011,1004,'你最好的朋友姓名','哼哼一');
insert  into passwordprotection values(2012,1004,'你最好异性名字','哼一哼');

insert  into passwordprotection values(2012,1005,'你自己的姓名','哈哈');
insert  into passwordprotection values(2013,1005,'你最好的朋友姓名','啊哈哈');
insert  into passwordprotection values(2014,1005,'你最好异性名字','哦哈哈');

insert  into passwordprotection values(2015,1006,'你自己的姓名','哼哼');
insert  into passwordprotection values(2016,1006,'你最好的朋友姓名','啊哼哼');
insert  into passwordprotection values(2017,1006,'你最好异性名字','哦哼哼');

insert  into passwordprotection values(2018,1007,'你自己的姓名','一哈哈');
insert  into passwordprotection values(2019,1007,'你最好的朋友姓名','哈哈一');
insert  into passwordprotection values(2020,1007,'你最好异性名字','哈一哈');


insert  into passwordprotection values(2021,1008,'你自己的姓名','一哼哼');
insert  into passwordprotection values(2022,1008,'你最好的朋友姓名','哼哼一');
insert  into passwordprotection values(2023,1008,'你最好异性名字','哼一哼');

insert  into passwordprotection values(2024,1009,'你自己的姓名','哈哈');
insert  into passwordprotection values(2025,1009,'你最好的朋友姓名','啊哈哈');
insert  into passwordprotection values(2026,1009,'你最好异性名字','哦哈哈');

insert  into passwordprotection values(2004,1010,'你自己的姓名','哼哼');
insert  into passwordprotection values(2005,1010,'你最好的朋友姓名','啊哼哼');
insert  into passwordprotection values(2006,1010,'你最好异性名字','哦哼哼');

insert  into passwordprotection values(2007,1011,'你自己的姓名','一哈哈');
insert  into passwordprotection values(2008,1011,'你最好的朋友姓名','哈哈一');
insert  into passwordprotection values(2009,1011,'你最好异性名字','哈一哈');


insert  into passwordprotection values(2010,1012,'你自己的姓名','一哼哼');
insert  into passwordprotection values(2011,1012,'你最好的朋友姓名','哼哼一');
insert  into passwordprotection values(2012,1012,'你最好异性名字','哼一哼');

insert  into passwordprotection values(2001,1013,'你自己的姓名','哈哈');
insert  into passwordprotection values(2002,1013,'你最好的朋友姓名','啊哈哈');
insert  into passwordprotection values(2003,1013,'你最好异性名字','哦哈哈');

insert  into passwordprotection values(2004,1014,'你自己的姓名','哼哼');
insert  into passwordprotection values(2005,1014,'你最好的朋友姓名','啊哼哼');
insert  into passwordprotection values(2006,1014,'你最好异性名字','哦哼哼');

insert  into passwordprotection values(2007,1015,'你自己的姓名','一哈哈');
insert  into passwordprotection values(2008,1015,'你最好的朋友姓名','哈哈一');
insert  into passwordprotection values(2009,1015,'你最好异性名字','哈一哈');


insert  into passwordprotection values(2010,1016,'你自己的姓名','一哼哼');
insert  into passwordprotection values(2011,1016,'你最好的朋友姓名','哼哼一');
insert  into passwordprotection values(2012,1016,'你最好异性名字','哼一哼');

/*商品表*/
insert into goods values(1111,'生日蛋糕','images/m1.png',100,'用于生日宴会以及家庭生日的一筐蛋糕');
insert into goods values(1112,'巧克力风味蛋糕','images/m2.png',152.50,'如果你是喜欢吃巧克力的人，这是绝对是非常棒的选择');
insert into goods values(1113,'三层塔式奶酪式蛋糕','images/m3.png',200,'如果是开宴会，这也是一款不错的选择');
insert into goods values(1114,'爱心巧克力蛋糕','images/m4.png',450.90,'这是一款适合约会使用一款蛋糕');
insert into goods values(1115,'七彩色式祷告','images/m5.png',320.40,'一款适合孩子们一起过生的蛋糕');
insert into goods values(1116,'三层粉色时蛋糕','images/m6.png',420.2,'用于女孩子生日聚会上使用');
insert into goods values(1117,'玫瑰花式蛋糕','images/m7.png',300,'典雅高端的宴会最热的选择');
insert into goods values(1118,'曲奇饼式蛋糕','images/m9.png',251.20,'十一款不错的早餐的蛋糕选择');
insert into goods values(1119,'翠绿三层塔式蛋糕','images/m1.png',300.20,'适合在野外聚会使用，具有独特的风趣，也是不错搭配选择');
insert into goods values(1120,'猫式粉色蛋糕','images/m3.png',400.50,'也是公主风式的搭配选择');
insert into goods values(1121,'生日蛋糕','images/m1.png',100,'用于生日宴会以及家庭生日的一筐蛋糕');
insert into goods values(1122,'巧克力风味蛋糕','images/m2.png',152.50,'如果你是喜欢吃巧克力的人，这是绝对是非常棒的选择');
insert into goods values(1123,'三层塔式奶酪式蛋糕','images/m3.png',200,'如果是开宴会，这也是一款不错的选择');
insert into goods values(1124,'爱心巧克力蛋糕','images/m4.png',450.90,'这是一款适合约会使用一款蛋糕');
insert into goods values(1125,'七彩色式祷告','images/m5.png',320.40,'一款适合孩子们一起过生的蛋糕');
insert into goods values(1126,'三层粉色时蛋糕','images/m6.png',420.2,'用于女孩子生日聚会上使用');
insert into goods values(1127,'玫瑰花式蛋糕','images/m7.png',300,'典雅高端的宴会最热的选择');
insert into goods values(1128,'曲奇饼式蛋糕','images/m9.png',251.20,'十一款不错的早餐的蛋糕选择');
insert into goods values(1129,'翠绿三层塔式蛋糕','images/m1.png',300.20,'适合在野外聚会使用，具有独特的风趣，也是不错搭配选择');
insert into goods values(1130,'猫式粉色蛋糕','images/m3.png',400.50,'也是公主风式的搭配选择');
insert into goods values(1131,'生日蛋糕','images/m1.png',100,'用于生日宴会以及家庭生日的一筐蛋糕');
insert into goods values(1132,'巧克力风味蛋糕','images/m2.png',152.50,'如果你是喜欢吃巧克力的人，这是绝对是非常棒的选择');
insert into goods values(1133,'三层塔式奶酪式蛋糕','images/m3.png',200,'如果是开宴会，这也是一款不错的选择');
insert into goods values(1134,'爱心巧克力蛋糕','images/m4.png',450.90,'这是一款适合约会使用一款蛋糕');
insert into goods values(1135,'七彩色式祷告','images/m5.png',320.40,'一款适合孩子们一起过生的蛋糕');
insert into goods values(1136,'三层粉色时蛋糕','images/m6.png',420.2,'用于女孩子生日聚会上使用');
insert into goods values(1137,'玫瑰花式蛋糕','images/m7.png',300,'典雅高端的宴会最热的选择');
insert into goods values(1138,'曲奇饼式蛋糕','images/m9.png',251.20,'十一款不错的早餐的蛋糕选择');
insert into goods values(1139,'翠绿三层塔式蛋糕','images/m1.png',300.20,'适合在野外聚会使用，具有独特的风趣，也是不错搭配选择');
insert into goods values(1140,'猫式粉色蛋糕','images/m3.png',400.50,'也是公主风式的搭配选择');

COMMIT ;
/*库存*/
insert into repertory values(1111,50);
insert into repertory values(1112,30);
insert into repertory values(1113,40);
insert into repertory values(1114,30);
insert into repertory values(1115,40);
insert into repertory values(1116,50);
insert into repertory values(1117,30);
insert into repertory values(1118,50);
insert into repertory values(1119,20);
insert into repertory values(1120,10);

insert into repertory values(1121,50);
insert into repertory values(1122,30);
insert into repertory values(1123,40);
insert into repertory values(1124,30);
insert into repertory values(1125,40);
insert into repertory values(1126,50);
insert into repertory values(1127,30);
insert into repertory values(1128,50);
insert into repertory values(1129,20);
insert into repertory values(1130,10);

insert into repertory values(1131,50);
insert into repertory values(1132,30);
insert into repertory values(1133,40);
insert into repertory values(1134,30);
insert into repertory values(1135,40);
insert into repertory values(1136,50);
insert into repertory values(1137,30);
insert into repertory values(1138,50);
insert into repertory values(1139,20);
insert into repertory values(1140,10);

/*意见*/
insert into opinion values(1,1111,1001,4,'非常满意');
insert into opinion values(2,1111,1003,4,'如果没有这款蛋糕，生日气氛也没有这么好');
insert into opinion values(3,1111,1002,4,'还不错');
insert into opinion values(4,1111,1004,4,'还不错');
insert into opinion values(5,1112,1001,4,'还不错');
insert into opinion values(6,1113,1002,4,'还不错');
insert into opinion values(7,1113,1004,4,'还不错');
insert into opinion values(8,1114,1002,4,'非常满意');
insert into opinion values(9,1114,1003,4,'还不错');
insert into opinion values(10,1115,1002,5,'非常满意');
insert into opinion values(11,1115,1003,5,'还不错');
insert into opinion values(12,1116,1004,5,'还不错');
insert into opinion values(13,1117,1001,4,'还不错');
insert into opinion values(14,1117,1001,4,'非常满意');
insert into opinion values(15,1118,1003,4,'还不错');
insert into opinion values(16,1119,1004,4,'非常满意');
insert into opinion values(17,1119,1002,4,'还不错');
insert into opinion values(18,1120,1003,4,'非常满意');



select * from goods
select * from wallet
select * from user
select * from userinfo
select * from passwordprotection
select * from repertory




DROP TABLE Opinion;

CREATE TABLE Opinion
(
  on_id          INT                           NOT NULL ,
  on_gid         INT                           NOT NULL ,
  on_uid         INT                           NOT NULL ,
  on_grade       INT                           NOT NULL ,
  on_discuss   VARCHAR (100)                     ,
  CONSTRAINT PK_OPINION_ONID PRIMARY KEY (on_id),
  FOREIGN KEY (on_gid) REFERENCES Goods (g_id)
);
ALTER TABLE Opinion modify on_id   INTEGER DEFAULT '1';
ALTER TABLE Opinion modify on_id   INTEGER auto_increment ;