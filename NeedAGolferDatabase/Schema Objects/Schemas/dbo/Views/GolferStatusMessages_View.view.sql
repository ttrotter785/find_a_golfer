CREATE VIEW [dbo].[GolferStatusMessages_View]
AS 
	SELECT
		G.GolferId,
		G.EmailAddress,
		G.PhoneNumber,
		G.Handicap,
		G.IsAvailable,
		G.AllowEmails,
		G.Latitude,
		G.Longitude,
		G.LastUpdated,
		G.ScreenName,
		G.PasswordHash,
		G.AvailabilityDistance,
		G.IsCourseUser,
		GOLFERSTATUS.Message,
		GOLFERSTATUS.MessageCreateDate,
		GOLFERRATINGS.Rating,
		GOLFERRATINGS.NumRatings,
		HOMECOURSE.CourseName
	FROM Golfer G WITH (NOLOCK)
		CROSS APPLY
			(SELECT TOP 1 [Message], MessageCreateDate
				FROM GolferStatusMessage GSM WITH (NOLOCK)
				WHERE GSM.GolferId = G.GolferId
				ORDER BY MessageCreateDate DESC) as GOLFERSTATUS
		OUTER APPLY
			(SELECT convert(decimal(18,2), AVG(Rating))  as Rating, 
					COUNT(*) as NumRatings 
				FROM GolferRatings WITH (NOLOCK)
				WHERE GolferId = G.GolferId) as GOLFERRATINGS
		LEFT JOIN GolfCourse HOMECOURSE WITH (NOLOCK)
			ON HOMECOURSE.GolfCourse_Id = G.HomeGolfCourseId
	WHERE G.IsAvailable = 1