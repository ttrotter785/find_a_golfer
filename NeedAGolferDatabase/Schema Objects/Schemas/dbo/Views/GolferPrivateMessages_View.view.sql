CREATE VIEW [dbo].[GolferPrivateMessages_View]
AS 
	SELECT
		MSG.GolferPrivateMessageId as MessageId,
		SENDER.ScreenName as SenderScreenName,
		SENDER.GolferId as SenderGolferId,
		RECEIVER.ScreenName as ReceiverScreenName,
		RECEIVER.GolferId as ReceiverGolferId,
		MSG.RootGolferMessageId,
		MSG.MessageCreateDate,
		MSG.Message
	FROM GolferPrivateMessage MSG WITH (NOLOCK)
		INNER JOIN Golfer SENDER WITH (NOLOCK)
			ON SENDER.GolferId = MSG.SendingGolferId
		INNER JOIN Golfer RECEIVER WITH (NOLOCK)
			ON RECEIVER.GolferId = MSG.ReceivingGolferId