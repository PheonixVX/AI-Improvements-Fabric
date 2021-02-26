package io.github.pheonixvx.aiimprovementsfabric.modifier.filters;

import net.minecraft.entity.Entity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/2/2019. Ported to Fabric by PheonixVX on 2/24/2021.
 */
public class FilterNode implements IFilterNode {
	protected int callCount = 0;

	protected final IFilterNode action;

	protected FilterNode(IFilterNode action)
	{
		this.action = action;
	}

	@Override
	public FilterResult handle(Entity entity)
	{
		return action.handle(entity);
	}
}
