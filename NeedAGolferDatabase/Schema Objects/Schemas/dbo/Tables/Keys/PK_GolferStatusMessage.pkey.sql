﻿ALTER TABLE [dbo].[GolferStatusMessage]
    ADD CONSTRAINT [PK_GolferStatusMessage] PRIMARY KEY CLUSTERED ([GolferMessageId] DESC) WITH (ALLOW_PAGE_LOCKS = ON, ALLOW_ROW_LOCKS = ON, PAD_INDEX = OFF, IGNORE_DUP_KEY = OFF, STATISTICS_NORECOMPUTE = OFF);
