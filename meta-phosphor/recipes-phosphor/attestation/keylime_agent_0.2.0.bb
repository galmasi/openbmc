inherit cargo

# Added from Angelo's old bitbake file

DEPENDS += "libarchive \
            zeromq \
            libtss2-dev \
           "

#RDEPENDS:${PN} += "tpm2-tools \
#                   tpm2-abrmd \
#                   tpm2-pkcs11 \
#                   libtss2 \
#                   libtss2-tcti-device \
#                   libtss2-tcti-mssim \
#                   gnutls \
#                   openssl \
#                   packagegroup-security-tpm2 \
#                   python3-core \
#                  "



# If this is git based prefer versioned ones if they exist
# DEFAULT_PREFERENCE = "-1"

# how to get keylime_agent could be as easy as but default to a git checkout:
# SRC_URI += "crate://crates.io/keylime_agent/0.2.0"
SRC_URI += "git://git@github.com/keylime/rust-keylime.git;protocol=ssh;nobranch=1"
SRCREV = "f4edfeb2266140c0d2df89862866e441006f7a94"
S = "${WORKDIR}/git"
CARGO_SRC_DIR = "keylime-agent"
PV:append = ".AUTOINC+f4edfeb226"

# please note if you have entries that do not begin with crate://
# you must change them to how that package can be fetched
SRC_URI += " \
    crate://crates.io/actix-codec/0.5.0 \
    crate://crates.io/actix-http/3.2.2 \
    crate://crates.io/actix-macros/0.2.3 \
    crate://crates.io/actix-router/0.5.1 \
    crate://crates.io/actix-rt/2.7.0 \
    crate://crates.io/actix-server/2.1.1 \
    crate://crates.io/actix-service/2.0.2 \
    crate://crates.io/actix-tls/3.0.3 \
    crate://crates.io/actix-utils/3.0.0 \
    crate://crates.io/actix-web-codegen/4.1.0 \
    crate://crates.io/actix-web/4.2.1 \
    crate://crates.io/adler/1.0.2 \
    crate://crates.io/ahash/0.7.6 \
    crate://crates.io/aho-corasick/0.7.19 \
    crate://crates.io/alloc-no-stdlib/2.0.4 \
    crate://crates.io/alloc-stdlib/0.2.2 \
    crate://crates.io/anyhow/1.0.65 \
    crate://crates.io/assert-json-diff/2.0.2 \
    crate://crates.io/async-channel/1.7.1 \
    crate://crates.io/async-trait/0.1.57 \
    crate://crates.io/atty/0.2.14 \
    crate://crates.io/autocfg/1.1.0 \
    crate://crates.io/base64/0.13.1 \
    crate://crates.io/bindgen/0.63.0 \
    crate://crates.io/bitfield/0.13.2 \
    crate://crates.io/bitflags/1.3.2 \
    crate://crates.io/block-buffer/0.10.3 \
    crate://crates.io/brotli-decompressor/2.3.2 \
    crate://crates.io/brotli/3.3.4 \
    crate://crates.io/bumpalo/3.12.0 \
    crate://crates.io/bytes/1.2.1 \
    crate://crates.io/bytestring/1.1.0 \
    crate://crates.io/cache-padded/1.2.0 \
    crate://crates.io/cc/1.0.73 \
    crate://crates.io/cexpr/0.6.0 \
    crate://crates.io/cfg-if/1.0.0 \
    crate://crates.io/clang-sys/1.4.0 \
    crate://crates.io/clap/3.2.23 \
    crate://crates.io/clap_derive/3.2.18 \
    crate://crates.io/clap_lex/0.2.4 \
    crate://crates.io/compress-tools/0.12.4 \
    crate://crates.io/concurrent-queue/1.2.4 \
    crate://crates.io/config/0.13.2 \
    crate://crates.io/convert_case/0.4.0 \
    crate://crates.io/cookie/0.16.1 \
    crate://crates.io/core-foundation-sys/0.8.3 \
    crate://crates.io/core-foundation/0.9.3 \
    crate://crates.io/cpufeatures/0.2.5 \
    crate://crates.io/crc32fast/1.3.2 \
    crate://crates.io/crypto-common/0.1.6 \
    crate://crates.io/deadpool-runtime/0.1.2 \
    crate://crates.io/deadpool/0.9.5 \
    crate://crates.io/derive_more/0.99.17 \
    crate://crates.io/digest/0.10.5 \
    crate://crates.io/dlv-list/0.3.0 \
    crate://crates.io/either/1.8.0 \
    crate://crates.io/encoding_rs/0.8.31 \
    crate://crates.io/enumflags2/0.7.5 \
    crate://crates.io/enumflags2_derive/0.7.4 \
    crate://crates.io/env_logger/0.7.1 \
    crate://crates.io/error-chain/0.10.0 \
    crate://crates.io/event-listener/2.5.3 \
    crate://crates.io/fastrand/1.8.0 \
    crate://crates.io/flate2/1.0.24 \
    crate://crates.io/fnv/1.0.7 \
    crate://crates.io/foreign-types-shared/0.1.1 \
    crate://crates.io/foreign-types/0.3.2 \
    crate://crates.io/form_urlencoded/1.1.0 \
    crate://crates.io/futures-channel/0.3.25 \
    crate://crates.io/futures-core/0.3.25 \
    crate://crates.io/futures-executor/0.3.25 \
    crate://crates.io/futures-io/0.3.25 \
    crate://crates.io/futures-lite/1.12.0 \
    crate://crates.io/futures-macro/0.3.25 \
    crate://crates.io/futures-sink/0.3.25 \
    crate://crates.io/futures-task/0.3.25 \
    crate://crates.io/futures-timer/3.0.2 \
    crate://crates.io/futures-util/0.3.25 \
    crate://crates.io/futures/0.3.25 \
    crate://crates.io/generic-array/0.14.6 \
    crate://crates.io/getrandom/0.1.16 \
    crate://crates.io/getrandom/0.2.7 \
    crate://crates.io/glob/0.3.0 \
    crate://crates.io/h2/0.3.14 \
    crate://crates.io/hashbrown/0.12.3 \
    crate://crates.io/heck/0.4.0 \
    crate://crates.io/hermit-abi/0.1.19 \
    crate://crates.io/hex/0.4.3 \
    crate://crates.io/hostname-validator/1.1.1 \
    crate://crates.io/http-body/0.4.5 \
    crate://crates.io/http-types/2.12.0 \
    crate://crates.io/http/0.2.8 \
    crate://crates.io/httparse/1.8.0 \
    crate://crates.io/httpdate/1.0.2 \
    crate://crates.io/humantime/1.3.0 \
    crate://crates.io/hyper-tls/0.5.0 \
    crate://crates.io/hyper/0.14.20 \
    crate://crates.io/idna/0.3.0 \
    crate://crates.io/indexmap/1.9.1 \
    crate://crates.io/infer/0.2.3 \
    crate://crates.io/instant/0.1.12 \
    crate://crates.io/ipnet/2.5.0 \
    crate://crates.io/itoa/1.0.3 \
    crate://crates.io/jobserver/0.1.25 \
    crate://crates.io/js-sys/0.3.60 \
    crate://crates.io/json5/0.4.1 \
    crate://crates.io/language-tags/0.3.2 \
    crate://crates.io/lazy_static/1.4.0 \
    crate://crates.io/lazycell/1.3.0 \
    crate://crates.io/libc/0.2.139 \
    crate://crates.io/libloading/0.7.3 \
    crate://crates.io/linked-hash-map/0.5.6 \
    crate://crates.io/local-channel/0.1.3 \
    crate://crates.io/local-waker/0.1.3 \
    crate://crates.io/lock_api/0.4.9 \
    crate://crates.io/log/0.4.17 \
    crate://crates.io/mbox/0.6.0 \
    crate://crates.io/memchr/2.5.0 \
    crate://crates.io/metadeps/1.1.2 \
    crate://crates.io/mime/0.3.16 \
    crate://crates.io/minimal-lexical/0.2.1 \
    crate://crates.io/miniz_oxide/0.5.4 \
    crate://crates.io/mio/0.8.4 \
    crate://crates.io/native-tls/0.2.10 \
    crate://crates.io/nom/7.1.1 \
    crate://crates.io/num-derive/0.3.3 \
    crate://crates.io/num-traits/0.2.15 \
    crate://crates.io/num_cpus/1.13.1 \
    crate://crates.io/num_threads/0.1.6 \
    crate://crates.io/oid/0.2.1 \
    crate://crates.io/once_cell/1.15.0 \
    crate://crates.io/openssl-macros/0.1.0 \
    crate://crates.io/openssl-probe/0.1.5 \
    crate://crates.io/openssl-sys/0.9.80 \
    crate://crates.io/openssl/0.10.45 \
    crate://crates.io/ordered-multimap/0.4.3 \
    crate://crates.io/os_str_bytes/6.3.0 \
    crate://crates.io/parking/2.0.0 \
    crate://crates.io/parking_lot/0.12.1 \
    crate://crates.io/parking_lot_core/0.9.3 \
    crate://crates.io/paste/1.0.9 \
    crate://crates.io/pathdiff/0.2.1 \
    crate://crates.io/peeking_take_while/0.1.2 \
    crate://crates.io/percent-encoding/2.2.0 \
    crate://crates.io/pest/2.3.1 \
    crate://crates.io/pest_derive/2.3.1 \
    crate://crates.io/pest_generator/2.3.1 \
    crate://crates.io/pest_meta/2.3.1 \
    crate://crates.io/picky-asn1-der/0.2.5 \
    crate://crates.io/picky-asn1-der/0.3.1 \
    crate://crates.io/picky-asn1-x509/0.6.1 \
    crate://crates.io/picky-asn1/0.3.3 \
    crate://crates.io/picky-asn1/0.5.0 \
    crate://crates.io/pin-project-lite/0.2.9 \
    crate://crates.io/pin-utils/0.1.0 \
    crate://crates.io/pkg-config/0.3.25 \
    crate://crates.io/ppv-lite86/0.2.16 \
    crate://crates.io/pretty_env_logger/0.4.0 \
    crate://crates.io/proc-macro-error-attr/1.0.4 \
    crate://crates.io/proc-macro-error/1.0.4 \
    crate://crates.io/proc-macro2/1.0.44 \
    crate://crates.io/quick-error/1.2.3 \
    crate://crates.io/quote/1.0.21 \
    crate://crates.io/rand/0.7.3 \
    crate://crates.io/rand/0.8.5 \
    crate://crates.io/rand_chacha/0.2.2 \
    crate://crates.io/rand_chacha/0.3.1 \
    crate://crates.io/rand_core/0.5.1 \
    crate://crates.io/rand_core/0.6.4 \
    crate://crates.io/rand_hc/0.2.0 \
    crate://crates.io/redox_syscall/0.2.16 \
    crate://crates.io/regex-syntax/0.6.27 \
    crate://crates.io/regex/1.6.0 \
    crate://crates.io/remove_dir_all/0.5.3 \
    crate://crates.io/reqwest/0.11.12 \
    crate://crates.io/retain_mut/0.1.9 \
    crate://crates.io/ron/0.7.1 \
    crate://crates.io/rust-ini/0.18.0 \
    crate://crates.io/rustc-hash/1.1.0 \
    crate://crates.io/rustc_version/0.3.3 \
    crate://crates.io/rustc_version/0.4.0 \
    crate://crates.io/ryu/1.0.11 \
    crate://crates.io/schannel/0.1.20 \
    crate://crates.io/scopeguard/1.1.0 \
    crate://crates.io/security-framework-sys/2.6.1 \
    crate://crates.io/security-framework/2.7.0 \
    crate://crates.io/semver-parser/0.10.2 \
    crate://crates.io/semver/0.11.0 \
    crate://crates.io/semver/1.0.14 \
    crate://crates.io/serde/1.0.145 \
    crate://crates.io/serde_bytes/0.11.7 \
    crate://crates.io/serde_derive/1.0.145 \
    crate://crates.io/serde_json/1.0.91 \
    crate://crates.io/serde_qs/0.8.5 \
    crate://crates.io/serde_urlencoded/0.7.1 \
    crate://crates.io/sha1/0.10.5 \
    crate://crates.io/shlex/1.1.0 \
    crate://crates.io/signal-hook-registry/1.4.0 \
    crate://crates.io/signal-hook/0.3.15 \
    crate://crates.io/slab/0.4.7 \
    crate://crates.io/smallvec/1.9.0 \
    crate://crates.io/socket2/0.4.7 \
    crate://crates.io/stable_deref_trait/1.2.0 \
    crate://crates.io/static_assertions/1.1.0 \
    crate://crates.io/strsim/0.10.0 \
    crate://crates.io/syn/1.0.100 \
    crate://crates.io/synstructure/0.12.6 \
    crate://crates.io/target-lexicon/0.12.4 \
    crate://crates.io/tempfile/3.3.0 \
    crate://crates.io/termcolor/1.1.3 \
    crate://crates.io/textwrap/0.16.0 \
    crate://crates.io/thiserror-impl/1.0.38 \
    crate://crates.io/thiserror/1.0.38 \
    crate://crates.io/time-macros/0.2.4 \
    crate://crates.io/time/0.3.14 \
    crate://crates.io/tinyvec/1.6.0 \
    crate://crates.io/tinyvec_macros/0.1.0 \
    crate://crates.io/tokio-native-tls/0.3.0 \
    crate://crates.io/tokio-openssl/0.6.3 \
    crate://crates.io/tokio-util/0.7.4 \
    crate://crates.io/tokio/1.24.2 \
    crate://crates.io/toml/0.2.1 \
    crate://crates.io/toml/0.5.9 \
    crate://crates.io/tower-service/0.3.2 \
    crate://crates.io/tracing-core/0.1.29 \
    crate://crates.io/tracing/0.1.36 \
    crate://crates.io/try-lock/0.2.3 \
    crate://crates.io/tss-esapi-sys/0.4.0 \
    crate://crates.io/tss-esapi/7.2.0 \
    crate://crates.io/typenum/1.15.0 \
    crate://crates.io/ucd-trie/0.1.5 \
    crate://crates.io/unicode-bidi/0.3.8 \
    crate://crates.io/unicode-ident/1.0.4 \
    crate://crates.io/unicode-normalization/0.1.22 \
    crate://crates.io/unicode-xid/0.2.4 \
    crate://crates.io/url/2.3.1 \
    crate://crates.io/uuid/1.3.0 \
    crate://crates.io/vcpkg/0.2.15 \
    crate://crates.io/version_check/0.9.4 \
    crate://crates.io/waker-fn/1.1.0 \
    crate://crates.io/want/0.3.0 \
    crate://crates.io/wasi/0.11.0+wasi-snapshot-preview1 \
    crate://crates.io/wasi/0.9.0+wasi-snapshot-preview1 \
    crate://crates.io/wasm-bindgen-backend/0.2.83 \
    crate://crates.io/wasm-bindgen-futures/0.4.33 \
    crate://crates.io/wasm-bindgen-macro-support/0.2.83 \
    crate://crates.io/wasm-bindgen-macro/0.2.83 \
    crate://crates.io/wasm-bindgen-shared/0.2.83 \
    crate://crates.io/wasm-bindgen/0.2.83 \
    crate://crates.io/web-sys/0.3.60 \
    crate://crates.io/which/4.3.0 \
    crate://crates.io/winapi-i686-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi-util/0.1.5 \
    crate://crates.io/winapi-x86_64-pc-windows-gnu/0.4.0 \
    crate://crates.io/winapi/0.3.9 \
    crate://crates.io/windows-sys/0.36.1 \
    crate://crates.io/windows-sys/0.42.0 \
    crate://crates.io/windows_aarch64_gnullvm/0.42.0 \
    crate://crates.io/windows_aarch64_msvc/0.36.1 \
    crate://crates.io/windows_aarch64_msvc/0.42.0 \
    crate://crates.io/windows_i686_gnu/0.36.1 \
    crate://crates.io/windows_i686_gnu/0.42.0 \
    crate://crates.io/windows_i686_msvc/0.36.1 \
    crate://crates.io/windows_i686_msvc/0.42.0 \
    crate://crates.io/windows_x86_64_gnu/0.36.1 \
    crate://crates.io/windows_x86_64_gnu/0.42.0 \
    crate://crates.io/windows_x86_64_gnullvm/0.42.0 \
    crate://crates.io/windows_x86_64_msvc/0.36.1 \
    crate://crates.io/windows_x86_64_msvc/0.42.0 \
    crate://crates.io/winreg/0.10.1 \
    crate://crates.io/wiremock/0.5.14 \
    crate://crates.io/yaml-rust/0.4.5 \
    crate://crates.io/zeroize/1.5.7 \
    crate://crates.io/zeroize_derive/1.3.2 \
    crate://crates.io/zmq-sys/0.11.0 \
    crate://crates.io/zmq/0.9.2 \
    crate://crates.io/zstd-safe/5.0.2+zstd.1.5.2 \
    crate://crates.io/zstd-sys/2.0.1+zstd.1.5.2 \
    crate://crates.io/zstd/0.11.2+zstd.1.5.2 \
"



# FIXME: update generateme with the real MD5 of the license file
LIC_FILES_CHKSUM = " \
    file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327 \
"

SUMMARY = "Rust agent for Keylime"
HOMEPAGE = "https://github.com/keylime/rust-keylime"
LICENSE = "Apache-2.0"

# includes this file if it exists but does not fail
# this is useful for anything you may want to override from
# what cargo-bitbake generates.
include keylime_agent-${PV}.inc
include keylime_agent.inc