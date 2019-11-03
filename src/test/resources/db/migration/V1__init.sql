create table if not exists characterlog
(
	id bigint not null ,
	characterid integer not null,
	episodelist integer not null,
	gender varchar(255),
	name varchar(255),
	species varchar(255),
	status varchar(255),
	type varchar(255)
);
ALTER TABLE characterlog ADD primary key (id) ;


create table if not exists commentlog
(
	id bigint not null ,
	comment varchar(500),
	createtime timestamp,
	ipaddress varchar(255)
);
ALTER TABLE commentlog ADD primary key (id) ;

create sequence if not exists hibernate_sequence;

create table if not exists episodelog
(
	id bigint not null ,
	airdate timestamp,
	charactercount integer not null,
	episodecode varchar(255),
	episodeid varchar(255),
	name varchar(255)
);
ALTER TABLE episodelog ADD primary key (id) ;


create table if not exists episodelog_commentlog
(
	episodelog_id bigint not null ,
	commentlogentitylist_id bigint not null
);

ALTER TABLE episodelog_commentlog add constraint fksqieagad4qxy55cy6uvovhvd2 foreign key (episodelog_id) references episodelog(id);
ALTER TABLE episodelog_commentlog add constraint uk_oyrgunjp49ss9492cgteg44u4 unique (commentlogentitylist_id) ;
ALTER TABLE episodelog_commentlog add constraint fkmascd2rqjkgndu88ul73aq8cv foreign key (commentlogentitylist_id) references commentlog(id);

