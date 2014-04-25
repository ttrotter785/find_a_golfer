CREATE TABLE [dbo].[Golfer] (
    [GolferId]             INT            IDENTITY (1, 1) NOT NULL,
    [EmailAddress]         VARCHAR (250)  NULL,
    [PhoneNumber]          VARCHAR (25)   NULL,
    [Handicap]             INT            NULL,
    [IsAvailable]          BIT            NULL,
    [AllowEmails]          BIT            NULL,
    [Latitude]             DECIMAL (9, 6) NULL,
    [Longitude]            DECIMAL (9, 6) NULL,
    [LastUpdated]          DATETIME       NULL,
    [ScreenName]           VARCHAR (255)  NULL,
    [PasswordHash]         VARCHAR (255)  NOT NULL,
    [AvailabilityDistance] INT            NULL,
    [IsCourseUser]         BIT            DEFAULT ((0)) NOT NULL,
    [HomeGolfCourseId]     INT            NULL,
    [PasswordSalt]         VARCHAR (255)  NULL,
    [timestamp]            TIMESTAMP      NOT NULL
);

