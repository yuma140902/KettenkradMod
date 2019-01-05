package yuma140902.kettenkradmod;

import java.io.File;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.block.BlockTrapDoor;
import net.minecraft.init.Items;
import net.minecraftforge.common.config.Configuration;
import yuma140902.kettenkradmod.proxy.CommonProxy;
import yuma140902.kettenkradmod.util.Stat;

@Mod(modid = ModKettenkradMod.MOD_ID, useMetadata = true)
public class ModKettenkradMod {
	@Mod.Metadata
	public static ModMetadata modMetadata;
	
	@Mod.Instance
	public static ModKettenkradMod INSTANCE;
	
	@SidedProxy(clientSide = Stat.PROXY_CLIENT, serverSide = Stat.PROXY_SERVER)
	public static CommonProxy proxy;
	
	public static final String MOD_ID = "kettenkradmod";
	public static final String MOD_NAME = "KettenkradMod";
	public static final String MINECRAFT_VERSION = "1.7.10";
	public static final String MOD_VERSION = "0.0.0";
	
	
	private void loadModMetadata(ModMetadata modMetadata) {
		modMetadata.modId = MOD_ID;
		modMetadata.name = MOD_NAME;
		modMetadata.version = MOD_VERSION;
		modMetadata.authorList.add("yuma140902");
		modMetadata.description = "少女終末旅行に登場するケッテンクラートを追加します";
		modMetadata.url = "https://yuma140902.wixsite.com/mcmod";
		modMetadata.autogenerated = false;
	}
	
	private void loadConfig(File configFile) {
		Configuration cfg = new Configuration(configFile);
		cfg.load();
		
		cfg.save();
	}
	
	private void tweakVanilla() {
		Items.wooden_door.setMaxStackSize(64);
		Items.iron_door.setMaxStackSize(64);
		BlockTrapDoor.disableValidation = true;
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		loadModMetadata(modMetadata);
		loadConfig(event.getSuggestedConfigurationFile());
		
		tweakVanilla();
		MyBlocks.register();
		MyItems.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		Recipes.register();
		proxy.registerEntities();
		proxy.registerRenderers();
		
		proxy.registerEventHandlers();
	}
}
