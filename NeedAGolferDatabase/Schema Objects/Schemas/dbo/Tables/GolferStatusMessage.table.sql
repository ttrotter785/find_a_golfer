CREATE TABLE [dbo].[GolferStatusMessage] (
    [GolferMessageId]   INT      IDENTITY (1, 1) NOT NULL,
    [GolferId]          INT      NOT NULL,
    [MessageCreateDate] DATETIME NULL,
    [Message]           TEXT     NULL
);

