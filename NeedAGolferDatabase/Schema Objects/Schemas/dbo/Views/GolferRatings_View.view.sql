CREATE VIEW [dbo].[GolferRatings_View]
AS 
	SELECT
		SUBMITTER.ScreenName as SubmitterName,
		GOLFER.GolferId,
		GR.CreateDateTime,
		GR.Rating,
		GR.Comments
	FROM GolferRatings GR WITH (NOLOCK)
	INNER JOIN Golfer SUBMITTER WITH (NOLOCK)
		ON GR.SubmittingGolferId = SUBMITTER.GolferId
	INNER JOIN Golfer GOLFER WITH (NOLOCK)
		ON GR.GolferId = GOLFER.GolferId