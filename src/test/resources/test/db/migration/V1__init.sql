create table if not exists characterlog
(
	id bigint not null
		constraint characterlog_pkey
			primary key,
	characterid integer not null,
	episodelist integer not null,
	gender varchar(255),
	name varchar(255),
	species varchar(255),
	status varchar(255),
	type varchar(255)
);

create table if not exists commentlog
(
	id bigint not null
		constraint commentlog_pkey
			primary key,
	comment varchar(500),
	createtime timestamp,
	ipaddress varchar(255)
);

create table if not exists episodelog
(
	id bigint not null
		constraint episodelog_pkey
			primary key,
	airdate timestamp,
	charactercount integer not null,
	episodecode varchar(255),
	episodeid varchar(255),
	name varchar(255)
);

create table if not exists episodelog_commentlog
(
	episodelog_id bigint not null
		constraint fksqieagad4qxy55cy6uvovhvd2
			references episodelog,
	commentlogentitylist_id bigint not null
		constraint uk_oyrgunjp49ss9492cgteg44u4
			unique
		constraint fkmascd2rqjkgndu88ul73aq8cv
			references commentlog
);

