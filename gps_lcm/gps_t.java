/* LCM type definition class file
 * This file was automatically generated by lcm-gen
 * DO NOT MODIFY BY HAND!!!!
 */

package gps_lcm;
 
import java.io.*;
import java.util.*;
import lcm.lcm.*;
 
public final class gps_t implements lcm.lcm.LCMEncodable
{
    public long time;
    public double latitude;
    public double longitude;
    public double altitude;
    public double easting;
    public double northing;
 
    public gps_t()
    {
    }
 
    public static final long LCM_FINGERPRINT;
    public static final long LCM_FINGERPRINT_BASE = 0x04b9e07162fccc9eL;
 
    static {
        LCM_FINGERPRINT = _hashRecursive(new ArrayList<Class<?>>());
    }
 
    public static long _hashRecursive(ArrayList<Class<?>> classes)
    {
        if (classes.contains(gps_lcm.gps_t.class))
            return 0L;
 
        classes.add(gps_lcm.gps_t.class);
        long hash = LCM_FINGERPRINT_BASE
            ;
        classes.remove(classes.size() - 1);
        return (hash<<1) + ((hash>>63)&1);
    }
 
    public void encode(DataOutput outs) throws IOException
    {
        outs.writeLong(LCM_FINGERPRINT);
        _encodeRecursive(outs);
    }
 
    public void _encodeRecursive(DataOutput outs) throws IOException
    {
        outs.writeLong(this.time); 
 
        outs.writeDouble(this.latitude); 
 
        outs.writeDouble(this.longitude); 
 
        outs.writeDouble(this.altitude); 
 
        outs.writeDouble(this.easting); 
 
        outs.writeDouble(this.northing); 
 
    }
 
    public gps_t(byte[] data) throws IOException
    {
        this(new LCMDataInputStream(data));
    }
 
    public gps_t(DataInput ins) throws IOException
    {
        if (ins.readLong() != LCM_FINGERPRINT)
            throw new IOException("LCM Decode error: bad fingerprint");
 
        _decodeRecursive(ins);
    }
 
    public static gps_lcm.gps_t _decodeRecursiveFactory(DataInput ins) throws IOException
    {
        gps_lcm.gps_t o = new gps_lcm.gps_t();
        o._decodeRecursive(ins);
        return o;
    }
 
    public void _decodeRecursive(DataInput ins) throws IOException
    {
        this.time = ins.readLong();
 
        this.latitude = ins.readDouble();
 
        this.longitude = ins.readDouble();
 
        this.altitude = ins.readDouble();
 
        this.easting = ins.readDouble();
 
        this.northing = ins.readDouble();
 
    }
 
    public gps_lcm.gps_t copy()
    {
        gps_lcm.gps_t outobj = new gps_lcm.gps_t();
        outobj.time = this.time;
 
        outobj.latitude = this.latitude;
 
        outobj.longitude = this.longitude;
 
        outobj.altitude = this.altitude;
 
        outobj.easting = this.easting;
 
        outobj.northing = this.northing;
 
        return outobj;
    }
 
}

