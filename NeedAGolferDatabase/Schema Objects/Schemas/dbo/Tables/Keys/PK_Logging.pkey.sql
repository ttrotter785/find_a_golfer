﻿ALTER TABLE [dbo].[Logging]
    ADD CONSTRAINT [PK_Logging] PRIMARY KEY CLUSTERED ([LoggingId] ASC) WITH (ALLOW_PAGE_LOCKS = ON, ALLOW_ROW_LOCKS = ON, PAD_INDEX = OFF, IGNORE_DUP_KEY = OFF, STATISTICS_NORECOMPUTE = OFF);

