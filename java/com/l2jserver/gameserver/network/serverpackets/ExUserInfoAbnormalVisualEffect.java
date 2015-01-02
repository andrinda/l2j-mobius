/*
 * Copyright (C) 2004-2014 L2J Server
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
package com.l2jserver.gameserver.network.serverpackets;

import com.l2jserver.gameserver.model.actor.instance.L2PcInstance;

/**
 * @author Sdw
 */
public class ExUserInfoAbnormalVisualEffect extends L2GameServerPacket
{
	private final L2PcInstance _activeChar;
	
	public ExUserInfoAbnormalVisualEffect(L2PcInstance cha)
	{
		_activeChar = cha;
	}
	
	@Override
	protected void writeImpl()
	{
		writeC(0xFE);
		writeH(0x158);
		
		writeD(_activeChar.getObjectId());
		writeD(_activeChar.getTransformationId());
		writeD(_activeChar.getAbnormalVisualEffectsList().size());
		
		for (int abnormalVisualEffectId : _activeChar.getAbnormalVisualEffectsList())
		{
			writeH(abnormalVisualEffectId);
		}
	}
}