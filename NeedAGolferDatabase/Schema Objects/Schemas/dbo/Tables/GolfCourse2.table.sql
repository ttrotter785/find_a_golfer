CREATE TABLE [dbo].[GolfCourse2] (
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
    [Longitude]     DECIMAL (18, 6) NULL
);

