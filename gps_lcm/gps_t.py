try:
    import cStringIO.StringIO as BytesIO
except ImportError:
    from io import BytesIO
import struct

class gps_t(object):
    __slots__ = ["time", "latitude", "longitude", "altitude", "easting", "northing"]

    def __init__(self):
        self.time = 0
        self.latitude = 0.0
        self.longitude = 0.0
        self.altitude = 0.0
        self.easting = 0.0
        self.northing = 0.0

    def encode(self):
        buf = BytesIO()
        buf.write(gps_t._get_packed_fingerprint())
        self._encode_one(buf)
        return buf.getvalue()

    def _encode_one(self, buf):
        buf.write(struct.pack(">qddddd", self.time, self.latitude, self.longitude, self.altitude, self.easting, self.northing))

    def decode(data):
        if hasattr(data, 'read'):
            buf = data
        else:
            buf = BytesIO(data)
        if buf.read(8) != gps_t._get_packed_fingerprint():
            raise ValueError("Decode error")
        return gps_t._decode_one(buf)
    decode = staticmethod(decode)

    def _decode_one(buf):
        self = gps_t()
        self.time, self.latitude, self.longitude, self.altitude, self.easting, self.northing = struct.unpack(">qddddd", buf.read(48))
        return self
    _decode_one = staticmethod(_decode_one)

    _hash = None
    def _get_hash_recursive(parents):
        if gps_t in parents: return 0
        tmphash = (0x4b9e07162fccc9e) & 0xffffffffffffffff
        tmphash  = (((tmphash<<1)&0xffffffffffffffff)  + (tmphash>>63)) & 0xffffffffffffffff
        return tmphash
    _get_hash_recursive = staticmethod(_get_hash_recursive)
    _packed_fingerprint = None

    def _get_packed_fingerprint():
        if gps_t._packed_fingerprint is None:
            gps_t._packed_fingerprint = struct.pack(">Q", gps_t._get_hash_recursive([]))
        return gps_t._packed_fingerprint
    _get_packed_fingerprint = staticmethod(_get_packed_fingerprint)

