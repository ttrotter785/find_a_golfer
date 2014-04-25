

/****** Object:  StoredProcedure [dbo].[NewStoredProcedure]    Script Date: 09/21/2010 07:43:36 ******/
CREATE PROCEDURE [dbo].[GetNearbyGolfers]
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

SELECT *
FROM [dbo].[GolferStatusMessages_View] G
WHERE (G.longitude BETWEEN @lng_min AND @lng_max)
AND (G.latitude BETWEEN @lat_min and @lat_max)
ORDER BY G.MessageCreateDate DESC;
END