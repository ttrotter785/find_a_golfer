CREATE TABLE [dbo].[GolfCourse_OpenTeeTime] (
    [GolfCourse_OpenTeeTime_Id]  INT      IDENTITY (1, 1) NOT NULL,
    [GolfCourseId]               INT      NULL,
    [TeeTime]                    DATETIME NULL,
    [GolfCourse_DiscountType_Id] INT      NULL,
    [DiscountAmount]             MONEY    NULL
);

