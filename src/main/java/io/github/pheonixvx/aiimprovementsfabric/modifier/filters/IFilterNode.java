package io.github.pheonixvx.aiimprovementsfabric.modifier.filters;

import net.minecraft.entity.Entity;

/**
 * Created by Dark(DarkGuardsman, Robert) on 8/2/2019. Ported by PheonixVX to Fabric on 2/24/2021.
 */
@FunctionalInterface
public interface IFilterNode
{
	/**
	 * Called to consume an entity
	 *
	 * @param entity - entity being modified
	 * @return true to consume, false to move on
	 */
	FilterResult handle(Entity entity);
}