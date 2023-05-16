package satisfyu.candlelight.networking;


import dev.architectury.networking.NetworkManager;
import net.minecraft.resources.ResourceLocation;
import satisfyu.candlelight.networking.packet.SyncTypewriterDataC2SPacket;
import satisfyu.candlelight.util.CandlelightIdentifier;

public class CandlelightMessages {
    public static final ResourceLocation TYPEWRITER_SYNC = new CandlelightIdentifier("typewriter_sync");

    public static void registerC2SPackets() {
        NetworkManager.registerReceiver(NetworkManager.Side.C2S, TYPEWRITER_SYNC, new SyncTypewriterDataC2SPacket());
    }
}