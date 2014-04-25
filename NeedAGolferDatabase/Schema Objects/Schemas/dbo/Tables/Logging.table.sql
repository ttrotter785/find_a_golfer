CREATE TABLE [dbo].[Logging] (
    [LoggingId]   INT           IDENTITY (1, 1) NOT NULL,
    [DeviceId]    VARCHAR (250) NULL,
    [OSVersion]   VARCHAR (250) NULL,
    [UserAccount] VARCHAR (250) NULL,
    [CreatedDate] DATETIME      NULL,
    [DeviceType]  VARCHAR (250) NULL
);

