CREATE TABLE [dbo].[GolfCourse_Event_ApprovedGolfer] (
    [GolfCourse_Event_ApprovedGolfer_Id] INT IDENTITY (1, 1) NOT NULL,
    [GolfCourse_EventId]                 INT NULL,
    [GolferId]                           INT NULL,
    [Accepted]                           BIT NULL
);

