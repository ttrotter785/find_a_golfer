CREATE TABLE [dbo].[GolferPrivateMessage] (
    [GolferPrivateMessageId] INT      IDENTITY (1, 1) NOT NULL,
    [SendingGolferId]        INT      NOT NULL,
    [ReceivingGolferId]      INT      NOT NULL,
    [RootGolferMessageId]    INT      NOT NULL,
    [MessageCreateDate]      DATETIME NULL,
    [Message]                TEXT     NULL
);

