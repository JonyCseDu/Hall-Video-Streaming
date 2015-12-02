/*
 * This file is part of VLCJ.
 *
 * VLCJ is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * VLCJ is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with VLCJ.  If not, see <http://www.gnu.org/licenses/>.
 *
 * Copyright 2009, 2010, 2011, 2012, 2013, 2014, 2015 Caprica Software Limited.
 */

package uk.co.caprica.vlcj.player.condition.conditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.co.caprica.vlcj.player.MediaPlayer;
import uk.co.caprica.vlcj.player.condition.DefaultCondition;

/**
 * Implementation of a condition that waits for the media player to report that
 * a video output has been created.
 */
public class VideoOutputCreatedCondition extends DefaultCondition<Integer> {

    /**
     * Log.
     */
    private final Logger logger = LoggerFactory.getLogger(VideoOutputCreatedCondition.class);

    /**
     * Create a condition.
     *
     * @param mediaPlayer media player
     */
    public VideoOutputCreatedCondition(MediaPlayer mediaPlayer) {
        super(mediaPlayer);
    }

    @Override
    public void videoOutput(MediaPlayer mediaPlayer, int newCount) {
        logger.debug("videoOutput(mediaPlayer={},newCount={})", mediaPlayer, newCount);
        ready(newCount);
    }
}
