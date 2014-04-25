CREATE TABLE [dbo].[GolferRatings] (
    [GolferRatingId]     INT      IDENTITY (1, 1) NOT NULL,
    [GolferId]           INT      NOT NULL,
    [SubmittingGolferId] INT      NOT NULL,
    [Rating]             INT      NOT NULL,
    [Comments]           TEXT     NULL,
    [CreateDateTime]     DATETIME NULL,
    PRIMARY KEY CLUSTERED ([GolferRatingId] ASC) WITH (ALLOW_PAGE_LOCKS = ON, ALLOW_ROW_LOCKS = ON, PAD_INDEX = OFF, IGNORE_DUP_KEY = OFF, STATISTICS_NORECOMPUTE = OFF)
);

