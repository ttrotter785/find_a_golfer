CREATE PROCEDURE dbo.GetNearbyGolfCourses
(
	@latitude decimal(9,6),
	@longitude decimal(9,6),
	@radius decimal(9,6)
)
AS
BEGIN

declare @lng_min decimal(9,6),
		@lng_max decimal(9,6),
		@lat_min decimal(18,9),
		@lat_max decimal(18,9)

--set @latitude=39.965100
--set @longitude=-86.00000;
--set @radius=5;

set @lng_min = @longitude - @radius/abs(cos(radians(@latitude))*69);
set @lng_max = @longitude + @radius/abs(cos(radians(@latitude))*69);
set @lat_min = @latitude - (@radius/69);
set @lat_max = @latitude + (@radius/69);

SELECT GC.GolfCourse_Id,
		GC.Category,
		GC.CourseName,
		GC.CourseType,
		GC.Address,
		GC.City,
		GC.County,
		GC.State,
		GC.ZipCode,
		GC.PhoneNumber,
		GC.Latitude,
		GC.Longitude,
		dbo.fnGetDistance(@latitude, @longitude, GC.Latitude, GC.Longitude, 'Miles') as Distance
FROM GolfCourse GC WITH (NOLOCK)
WHERE (longitude BETWEEN @lng_min AND @lng_max)
AND (latitude BETWEEN @lat_min and @lat_max)
order by dbo.fnGetDistance(@latitude, @longitude, GC.Latitude, GC.Longitude, 'Miles')  asc

END