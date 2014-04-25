CREATE TABLE [dbo].[GolfCourse_GroupEvent] (
    [GolfCourse_Event_Id] INT      IDENTITY (1, 1) NOT NULL,
    [GolfCourseId]        INT      NULL,
    [Organizer_GolferId]  INT      NULL,
    [EventTime]           DATETIME NULL,
    [IsFulfilled]         BIT      NULL
);

