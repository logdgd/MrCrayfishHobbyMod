package com.mrcrayfish.rccar;

import com.mrcrayfish.rccar.event.ModEvents;
import com.mrcrayfish.rccar.init.ModCrafting;
import com.mrcrayfish.rccar.init.ModEntities;
import com.mrcrayfish.rccar.init.ModItems;
import com.mrcrayfish.rccar.init.ModSounds;
import com.mrcrayfish.rccar.network.PacketHandler;
import com.mrcrayfish.rccar.proxy.IProxy;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_MC_VERSIONS)
public class MrCrayfishRCCarMod 
{
	@Instance
	public static MrCrayfishRCCarMod instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS)
	public static IProxy proxy;
	
	public static final CreativeTabs TAB_CAR = new TabCar();
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ModItems.init();
		ModItems.register();
		ModEntities.register();
		ModCrafting.init();
		ModSounds.register();
		proxy.preInit();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init();
		
		PacketHandler.init();
		
	}
}
