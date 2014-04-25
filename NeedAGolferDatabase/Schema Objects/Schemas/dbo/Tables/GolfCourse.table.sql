CREATE TABLE [dbo].[GolfCourse] (
	[GolfCourse_Id] INT             IDENTITY (1, 1) NOT NULL,
	[Category]      VARCHAR (20)    NULL,
	[CourseName]    VARCHAR (250)   NULL,
	[CourseType]    VARCHAR (50)    NULL,
	[Address]       VARCHAR (250)   NULL,
	[City]          VARCHAR (250)   NULL,
	[County]        VARCHAR (250)   NULL,
	[State]         VARCHAR (20)    NULL,
	[ZipCode]       VARCHAR (50)    NULL,
	[PhoneNumber]   VARCHAR (25)    NULL,
	[Latitude]      DECIMAL (18, 6) NULL,
	[Longitude]     DECIMAL (18, 6) NULL,
 CONSTRAINT [PK_GolfCourse] PRIMARY KEY CLUSTERED 
(
	[GolfCourse_Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
;



