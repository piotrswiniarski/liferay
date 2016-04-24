create table online_App (
	onlineAppId LONG not null primary key,
	appName VARCHAR(75) null,
	appBody STRING null,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	appDescription VARCHAR(75) null,
	appLanguage VARCHAR(75) null,
	release_ VARCHAR(75) null,
	live BOOLEAN
);