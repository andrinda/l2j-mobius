/*
 * Copyright (C) 2004-2015 L2J Server
 * 
 * This file is part of L2J Server.
 * 
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.model.drops;

import com.l2jserver.Config;

/**
 * @author NosBit
 */
public class DeathDropItem extends GeneralDropItem
{
	/**
	 * @param itemId the item id
	 * @param min the min count
	 * @param max the max count
	 * @param chance the chance of this drop item
	 */
	public DeathDropItem(int itemId, long min, long max, double chance)
	{
		super(itemId, min, max, chance);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.l2jserver.gameserver.model.drops.GeneralDropItem#getGlobalAmountMultiplier()
	 */
	@Override
	protected double getGlobalAmountMultiplier(boolean isPremium)
	{
		return isPremium ? Config.PREMIUM_RATE_DROP_AMOUNT * Config.RATE_DEATH_DROP_AMOUNT_MULTIPLIER : Config.RATE_DEATH_DROP_AMOUNT_MULTIPLIER;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.l2jserver.gameserver.model.drops.GeneralDropItem#getGlobalChanceMultiplier()
	 */
	@Override
	protected double getGlobalChanceMultiplier(boolean isPremium)
	{
		return isPremium ? Config.PREMIUM_RATE_DROP_CHANCE * Config.RATE_DEATH_DROP_CHANCE_MULTIPLIER : Config.RATE_DEATH_DROP_CHANCE_MULTIPLIER;
	}
}
